/*******************************************************************************
 * Copyright (c) 2001, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Jens Lukowski/Innoopract - initial renaming/restructuring
 *     
 *******************************************************************************/
package org.eclipse.jst.jsp.core.internal.contenttype;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.content.IContentDescriber;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.content.ITextContentDescriber;
import org.eclipse.wst.sse.core.internal.encoding.EncodingMemento;
import org.eclipse.wst.sse.core.internal.encoding.IContentDescriptionExtended;
import org.eclipse.wst.sse.core.internal.encoding.IResourceCharsetDetector;

public abstract class AbstractContentDescriber implements ITextContentDescriber {

	private final static QualifiedName[] SUPPORTED_OPTIONS = {IContentDescription.CHARSET, IContentDescription.BYTE_ORDER_MARK, IContentDescriptionExtended.DETECTED_CHARSET, IContentDescriptionExtended.UNSUPPORTED_CHARSET, IContentDescriptionExtended.APPROPRIATE_DEFAULT};

	private void calculateSupportedOptions(InputStream contents, IContentDescription description) throws IOException {
		if (isRelevent(description)) {
			IResourceCharsetDetector detector = getDetector();
			detector.set(contents);
			handleCalculations(description, detector);
		}
	}

	/**
	 * @param contents
	 * @param description
	 * @throws IOException
	 */
	private void calculateSupportedOptions(Reader contents, IContentDescription description) throws IOException {
		if (isRelevent(description)) {
			IResourceCharsetDetector detector = getDetector();
			detector.set(contents);
			handleCalculations(description, detector);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.content.IContentDescriber#describe(java.io.InputStream,
	 *      org.eclipse.core.runtime.content.IContentDescription)
	 */
	public int describe(InputStream contents, IContentDescription description) throws IOException {
		int result = IContentDescriber.VALID;

		calculateSupportedOptions(contents, description);

		// assume if we're called at all that we are valid (few types could be
		// disproved, maybe XML -- or, maybe if exception occurs above?)
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.content.ITextContentDescriber#describe(java.io.Reader,
	 *      org.eclipse.core.runtime.content.IContentDescription)
	 */
	public int describe(Reader contents, IContentDescription description) throws IOException {
		int result = IContentDescriber.VALID;

		calculateSupportedOptions(contents, description);

		// assume if we're called at all that we are valid (few types could be
		// disproved, maybe XML -- or, maybe if exception occurs above?)
		return result;
	}

	protected abstract IResourceCharsetDetector getDetector();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.content.IContentDescriber#getSupportedOptions()
	 */
	public QualifiedName[] getSupportedOptions() {

		return SUPPORTED_OPTIONS;
	}

	/**
	 * @param description
	 * @param detector
	 * @throws IOException
	 */
	protected void handleCalculations(IContentDescription description, IResourceCharsetDetector detector) throws IOException {
		// note: if we're asked for one, we set them all. I need to be sure if
		// called
		// mulitiple times (one for each, say) that we don't waste time
		// processing same
		// content again.
		EncodingMemento encodingMemento = detector.getEncodingMemento();
		// TODO: I need to verify to see if this BOM work is always done
		// by text type.
		Object detectedByteOrderMark = encodingMemento.getUnicodeBOM();
		if (detectedByteOrderMark != null) {
			Object existingByteOrderMark = description.getProperty(IContentDescription.BYTE_ORDER_MARK);
			// not sure why would ever be different, so if is different, may
			// need to "push" up into base.
			if (!detectedByteOrderMark.equals(existingByteOrderMark))
				description.setProperty(IContentDescription.BYTE_ORDER_MARK, detectedByteOrderMark);
		}


		if (!encodingMemento.isValid()) {
			// note: after setting here, its the mere presence of
			// IContentDescriptionExtended.UNSUPPORTED_CHARSET
			// in the resource's description that can be used to determine if
			// invalid
			// in those cases, the "detected" property contains an
			// "appropriate default" to use.
			description.setProperty(IContentDescriptionExtended.UNSUPPORTED_CHARSET, encodingMemento.getInvalidEncoding());
			description.setProperty(IContentDescriptionExtended.APPROPRIATE_DEFAULT, encodingMemento.getAppropriateDefault());
		}

		Object detectedCharset = encodingMemento.getDetectedCharsetName();
		Object javaCharset = encodingMemento.getJavaCharsetName();

		// we always include detected, if its different than java
		handleDetectedSpecialCase(description, detectedCharset, javaCharset);

		if (javaCharset != null) {
			Object existingCharset = description.getProperty(IContentDescription.CHARSET);
			if (javaCharset.equals(existingCharset)) {
				handleDetectedSpecialCase(description, detectedCharset, javaCharset);
			} else {
				// we may need to add what we found, but only need to add
				// if different from default.the
				Object defaultCharset = getDetector().getSpecDefaultEncoding();
				if (defaultCharset != null) {
					if (!defaultCharset.equals(javaCharset)) {
						description.setProperty(IContentDescription.CHARSET, javaCharset);
					}
				} else {
					// assuming if there is no spec default, we always need to
					// add, I'm assuming
					description.setProperty(IContentDescription.CHARSET, javaCharset);
				}
			}
		}

		// avoid adding anything if not absolutly needed, since always
		// "cached" per session
		//description.setProperty(IContentDescriptionExtended.ENCODING_MEMENTO,
		// encodingMemento);
	}

	private void handleDetectedSpecialCase(IContentDescription description, Object detectedCharset, Object javaCharset) {
		// since equal, we don't need to add, but if our detected version is
		// different than
		// javaCharset, then we should add it. This will happen, for example,
		// if there's
		// differences in case, or differences due to override properties
		if (detectedCharset != null) {
			//			if (!detectedCharset.equals(javaCharset)) {
			//				description.setProperty(IContentDescriptionExtended.DETECTED_CHARSET,
			// detectedCharset);
			//			}

			// Once we detected a charset, we should set the property even
			// though it's the same as javaCharset
			// because there are clients that rely on this property to
			// determine if the charset is actually detected in file or not.
			description.setProperty(IContentDescriptionExtended.DETECTED_CHARSET, detectedCharset);
		}
	}

	/**
	 * @param description
	 * @return
	 */
	private boolean isRelevent(IContentDescription description) {
		boolean result = false;
		if (description == null)
			result = false;
		else if (description.isRequested(IContentDescription.BYTE_ORDER_MARK))
			result = true;
		else if (description.isRequested(IContentDescription.CHARSET))
			result = true;
		else if (description.isRequested(IContentDescriptionExtended.APPROPRIATE_DEFAULT))
			result = true;
		else if (description.isRequested(IContentDescriptionExtended.DETECTED_CHARSET))
			result = true;
		else if (description.isRequested(IContentDescriptionExtended.UNSUPPORTED_CHARSET))
			result = true;
		//		else if
		// (description.isRequested(IContentDescriptionExtended.ENCODING_MEMENTO))
		//			result = true;
		return result;
	}


}

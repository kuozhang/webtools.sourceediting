/*******************************************************************************
 * Copyright (c) 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.wst.css.core.internal.tasks;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.wst.css.core.parser.CSSRegionContexts;
import org.eclipse.wst.sse.core.participants.TaskTagSeeker;
import org.eclipse.wst.sse.core.text.IStructuredDocumentRegion;
import org.eclipse.wst.sse.core.text.ITextRegion;


public class CSSTaskTagSeeker extends TaskTagSeeker {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.sse.model.builder.participants.TaskTagSeeker#getCommentedText(org.eclipse.jface.text.IDocument,
	 *      int, int)
	 */
	protected String getCommentedText(IDocument document, int begin, int length) throws BadLocationException {
		String text = super.getCommentedText(document, begin, length);
		if (text != null && text.endsWith("*/")) { //$NON-NLS-1$
			text = text.substring(0, text.length() - 2);
		}
		return text;
	}

	protected boolean isCommentRegion(IStructuredDocumentRegion region, ITextRegion textRegion) {
		return textRegion.getType().equals(CSSRegionContexts.CSS_COMMENT);
	}
}
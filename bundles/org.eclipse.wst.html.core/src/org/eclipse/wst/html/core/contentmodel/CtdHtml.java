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
package org.eclipse.wst.html.core.contentmodel;



import java.util.Arrays;

import org.eclipse.wst.common.contentmodel.CMElementDeclaration;
import org.eclipse.wst.common.contentmodel.CMGroup;
import org.eclipse.wst.common.contentmodel.CMNode;
import org.eclipse.wst.html.core.HTML40Namespace;

/**
 * Complex type definition for <code>HTML</code>.<br>
 * Content Model:
 * HEAD, (FRAMESET|BODY)<br>
 */
final class CtdHtml extends ComplexTypeDefinition {

	/**
	 */
	public CtdHtml(ElementCollection elementCollection) {
		super(elementCollection);
		primaryCandidateName = HTML40Namespace.ElementName.HEAD;
	}

	/**
	 * (%html.content;).
	 * %html.content; is HEAD, (FRAMESET | BODY).
	 * @see com.ibm.sed.contentmodel.html.ComplexTypeDefinition
	 */
	protected void createContent() {
		if (content != null)
			return; // already created.
		if (collection == null)
			return;

		// ( )
		content = new CMGroupImpl(CMGroup.SEQUENCE, 1, 1);
		if (content == null)
			return;

		// HEAD
		CMNode edec = collection.getNamedItem(HTML40Namespace.ElementName.HEAD);
		if (edec != null)
			content.appendChild(edec);

		// ( | )
		CMGroupImpl group = new CMGroupImpl(CMGroup.CHOICE, 1, 1);
		content.appendChild(group);

		// FRAMESET, BODY
		String[] names = {HTML40Namespace.ElementName.FRAMESET, HTML40Namespace.ElementName.BODY};
		collection.getDeclarations(group, Arrays.asList(names).iterator());
	}

	/**
	 * Element content.
	 * @see com.ibm.sed.contentmodel.html.ComplexTypeDefinition
	 */
	public int getContentType() {
		return CMElementDeclaration.ELEMENT;
	}

	/**
	 * @see com.ibm.sed.contentmodel.html.ComplexTypeDefinition
	 */
	public String getTypeName() {
		return ComplexTypeDefinitionFactory.CTYPE_HTML;
	}
}
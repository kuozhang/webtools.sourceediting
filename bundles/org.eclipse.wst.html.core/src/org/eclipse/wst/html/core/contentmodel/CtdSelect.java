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



import org.eclipse.wst.common.contentmodel.CMElementDeclaration;
import org.eclipse.wst.common.contentmodel.CMGroup;
import org.eclipse.wst.common.contentmodel.CMNode;
import org.eclipse.wst.html.core.HTML40Namespace;

/**
 * for SELECT.
 */
final class CtdSelect extends ComplexTypeDefinition {

	/**
	 * @param elementCollection ElementCollection
	 */
	public CtdSelect(ElementCollection elementCollection) {
		super(elementCollection);
		primaryCandidateName = HTML40Namespace.ElementName.OPTION;
	}

	/**
	 * (OPTGROUP | OPTION)+.
	 */
	protected void createContent() {
		if (content != null)
			return; // already created.
		if (collection == null)
			return;

		// ( | )+
		content = new CMGroupImpl(CMGroup.CHOICE, 1, CMContentImpl.UNBOUNDED);
		// OPTGROUP
		CMNode dec = collection.getNamedItem(HTML40Namespace.ElementName.OPTGROUP);
		if (dec != null)
			content.appendChild(dec);
		// OPTION
		dec = collection.getNamedItem(HTML40Namespace.ElementName.OPTION);
		if (dec != null)
			content.appendChild(dec);
	}

	/**
	 * (OPTGROUP | OPTION)+.
	 * @return int; Should be one of ANY, EMPTY, ELEMENT, MIXED, PCDATA, CDATA,
	 * those are defined in CMElementDeclaration.
	 */
	public int getContentType() {
		return CMElementDeclaration.ELEMENT;
	}

	/**
	 * @return java.lang.String
	 */
	public String getTypeName() {
		return ComplexTypeDefinitionFactory.CTYPE_SELECT;
	}
}
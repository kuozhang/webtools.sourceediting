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
 * PARAM container.  For OBJECT and APPLET.
 */
final class CtdParamContainer extends ComplexTypeDefinition {

	/**
	 * @param elementCollection ElementCollection
	 */
	public CtdParamContainer(ElementCollection elementCollection) {
		super(elementCollection);
	}

	/**
	 * (PARAM | %flow;)*.
	 */
	protected void createContent() {
		if (content != null)
			return; // already created.
		if (collection == null)
			return;

		// ( | )*
		content = new CMGroupImpl(CMGroup.CHOICE, 0, CMContentImpl.UNBOUNDED);
		// PARAM
		CMNode param = collection.getNamedItem(HTML40Namespace.ElementName.PARAM);
		if (param != null)
			content.appendChild(param);
		// %flow;
		CMGroupImpl flows = new CMGroupImpl(CMGroup.CHOICE, 1, 1);
		if (flows == null)
			return;
		collection.getInline(flows);
		content.appendChild(flows);
	}

	/**
	 * (PARAM | %flow;)*.
	 * Because %flow; contains #PCDATA, the type is MIXED.
	 * @return int; Should be one of ANY, EMPTY, ELEMENT, MIXED, PCDATA, CDATA,
	 * those are defined in CMElementDeclaration.
	 */
	public int getContentType() {
		return CMElementDeclaration.MIXED;
	}

	/**
	 * @return java.lang.String
	 */
	public String getTypeName() {
		return ComplexTypeDefinitionFactory.CTYPE_PARAM_CONTAINER;
	}
}
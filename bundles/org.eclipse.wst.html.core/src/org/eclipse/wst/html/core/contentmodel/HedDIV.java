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



import org.eclipse.wst.common.contentmodel.CMNamedNodeMap;
import org.eclipse.wst.html.core.HTML40Namespace;

/**
 * DIV.
 */
final class HedDIV extends HedFlowContainer {

	/**
	 */
	public HedDIV(ElementCollection collection) {
		super(HTML40Namespace.ElementName.DIV, collection);
		layoutType = LAYOUT_BLOCK;
	}

	/**
	 * %attrs;
	 * %align;
	 * %reserved;
	 */
	protected void createAttributeDeclarations() {
		if (attributes != null)
			return; // already created.
		if (attributeCollection == null)
			return; // fatal

		attributes = new CMNamedNodeMapImpl();

		// %attrs;
		attributeCollection.getAttrs(attributes);
		// %align;
		HTMLAttrDeclImpl attr = AttributeCollection.createAlignForParagraph();
		if (attr != null)
			attributes.putNamedItem(HTML40Namespace.ATTR_NAME_ALIGN, attr);
		// %reserved; ... empty
	}

	/**
	 */
	public CMNamedNodeMap getProhibitedAncestors() {
		if (prohibitedAncestors != null)
			return prohibitedAncestors;

		String[] names = {HTML40Namespace.ElementName.DIR, HTML40Namespace.ElementName.MENU};
		prohibitedAncestors = elementCollection.getDeclarations(names);

		return prohibitedAncestors;
	}
}
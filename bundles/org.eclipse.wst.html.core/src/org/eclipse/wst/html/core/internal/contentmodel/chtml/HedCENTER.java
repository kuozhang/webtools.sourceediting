/*******************************************************************************
 * Copyright (c) 2004, 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.wst.html.core.internal.contentmodel.chtml;



import org.eclipse.wst.xml.core.internal.contentmodel.CMNamedNodeMap;

/**
 * CENTER.
 */
final class HedCENTER extends HedFlowContainer {

	/**
	 */
	public HedCENTER(ElementCollection collection) {
		super(CHTMLNamespace.ElementName.CENTER, collection);
		layoutType = LAYOUT_BLOCK;
	}

	/**
	 * %attrs;
	 */
	protected void createAttributeDeclarations() {
		if (attributes != null)
			return; // already created.
		if (attributeCollection == null)
			return; // fatal

		attributes = new CMNamedNodeMapImpl();

		// %attrs;
		attributeCollection.getAttrs(attributes);
	}

	/**
	 */
	public CMNamedNodeMap getProhibitedAncestors() {
		if (prohibitedAncestors != null)
			return prohibitedAncestors;

		String[] names = {CHTMLNamespace.ElementName.DIR, CHTMLNamespace.ElementName.MENU};
		prohibitedAncestors = elementCollection.getDeclarations(names);

		return prohibitedAncestors;
	}
}

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
package org.eclipse.wst.html.core.contentmodel.chtml;



import java.util.Arrays;

/**
 * BASE.
 */
final class HedBASE extends HedEmpty {

	/**
	 */
	public HedBASE(ElementCollection collection) {
		super(CHTMLNamespace.ElementName.BASE, collection);
		// LAYOUT_HIDDEN.
		// Because, BASE is GROUP_HIDDEN in the C++DOM/DTDParser.cpp.
		layoutType = LAYOUT_HIDDEN;
	}

	/**
	 * BASE.
	 * (href %URI; #IMPLIED)
	 * (target %FrameTarget; #IMPLIED)
	 */
	protected void createAttributeDeclarations() {
		if (attributes != null)
			return; // already created.
		if (attributeCollection == null)
			return; // fatal

		attributes = new CMNamedNodeMapImpl();

		String[] names = {CHTMLNamespace.ATTR_NAME_HREF,};
		attributeCollection.getDeclarations(attributes, Arrays.asList(names).iterator());
	}
}
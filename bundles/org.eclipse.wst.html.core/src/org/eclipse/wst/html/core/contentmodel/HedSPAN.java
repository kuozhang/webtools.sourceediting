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

import org.eclipse.wst.html.core.HTML40Namespace;



/**
 * SPAN.
 */
final class HedSPAN extends HedInlineContainer {

	/**
	 * SPAN.
	 */
	public HedSPAN(ElementCollection collection) {
		super(HTML40Namespace.ElementName.SPAN, collection);
	}

	/**
	 * %attrs;
	 * %reserved; ... empty.
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
}
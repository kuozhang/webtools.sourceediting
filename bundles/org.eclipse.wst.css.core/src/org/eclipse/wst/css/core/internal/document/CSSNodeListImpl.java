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
package org.eclipse.wst.css.core.internal.document;



import org.eclipse.wst.css.core.document.ICSSNode;
import org.eclipse.wst.css.core.document.ICSSNodeList;

/**
 * 
 */
class CSSNodeListImpl extends AbstractCSSNodeList implements ICSSNodeList {

	/**
	 * CSSNodeListImpl constructor comment.
	 */
	CSSNodeListImpl() {
		super();
	}

	/**
	 * @return com.ibm.sed.treemodel.css.CSSNode
	 * @param index
	 *            int
	 */
	public ICSSNode item(int index) {
		return itemImpl(index);
	}
}
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



import org.eclipse.wst.common.contentmodel.CMNode;
import org.eclipse.wst.common.contentmodel.CMNodeList;

/**
 * Analog of dom.NodeList for CM.
 * So, the implementation is very similar to
 * {@link com.ibm.sed.model.xml.NodeListImpl}.<br>
 */
class CMNodeListImpl implements CMNodeList {

	private java.util.Vector nodes = null;

	/**
	 * CMNodeListImpl constructor comment.
	 */
	public CMNodeListImpl() {
		super();
		nodes = new java.util.Vector();
	}

	/**
	 * @return org.eclipse.wst.common.contentmodel.CMNode
	 * @param node org.eclipse.wst.common.contentmodel.CMNode
	 */
	protected CMNode appendNode(CMNode node) {
		nodes.addElement(node);
		return node;
	}

	/**
	 * getLength method
	 * @return int
	 */
	public int getLength() {
		return nodes.size();
	}

	/**
	 * item method
	 * @return CMNode
	 * @param index int
	 */
	public CMNode item(int index) {
		if (index < 0 || index >= nodes.size())
			return null;
		return (CMNode) nodes.elementAt(index);
	}
}
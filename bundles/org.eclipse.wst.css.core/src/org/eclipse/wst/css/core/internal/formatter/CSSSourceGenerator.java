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
package org.eclipse.wst.css.core.internal.formatter;



import org.eclipse.jface.text.IRegion;
import org.eclipse.wst.css.core.document.ICSSAttr;
import org.eclipse.wst.css.core.document.ICSSNode;


public interface CSSSourceGenerator extends CSSSourceFormatter {

	/**
	 * 
	 */
	StringBuffer formatAttrChanged(ICSSNode node, ICSSAttr attr, boolean insert, AttrChangeContext region);

	/**
	 * 
	 */
	StringBuffer formatBefore(ICSSNode node, ICSSNode child, IRegion exceptFor);

	/**
	 * 
	 */
	int getAttrInsertPos(ICSSNode node, String attrName);

	/**
	 * 
	 */
	int getChildInsertPos(ICSSNode node);

	/**
	 * 
	 * @return int
	 * @param node
	 *            org.eclipse.wst.css.core.model.interfaces.ICSSNode
	 * @param insertPos
	 *            int
	 */
	int getLengthToReformatAfter(ICSSNode node, int insertPos);

	/**
	 * 
	 * @return int
	 * @param node
	 *            org.eclipse.wst.css.core.model.interfaces.ICSSNode
	 * @param insertPos
	 *            int
	 */
	int getLengthToReformatBefore(ICSSNode node, int insertPos);
}
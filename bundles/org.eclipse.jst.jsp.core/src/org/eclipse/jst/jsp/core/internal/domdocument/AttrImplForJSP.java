/*******************************************************************************
 * Copyright (c) 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     
 *******************************************************************************/

package org.eclipse.jst.jsp.core.internal.domdocument;

import org.eclipse.jst.jsp.core.model.parser.XMLJSPRegionContexts;
import org.eclipse.wst.xml.core.internal.document.AttrImpl;
import org.w3c.dom.Document;

public class AttrImplForJSP extends AttrImpl {

	protected boolean isNestedLanguageOpening(String regionType) {
		boolean result = regionType == XMLJSPRegionContexts.JSP_SCRIPTLET_OPEN || regionType == XMLJSPRegionContexts.JSP_EXPRESSION_OPEN || regionType == XMLJSPRegionContexts.JSP_DECLARATION_OPEN || regionType == XMLJSPRegionContexts.JSP_DIRECTIVE_OPEN;
		return result;
	}
	protected void setOwnerDocument(Document ownerDocument) {
		super.setOwnerDocument(ownerDocument);
	}
	protected void setName(String name) {
		super.setName(name);
	}
	protected void setNamespaceURI(String namespaceURI) {
		super.setNamespaceURI(namespaceURI);
	}

}

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
package org.eclipse.jst.jsp.core.internal.document;

import org.eclipse.wst.sse.core.IAdapterFactory;
import org.eclipse.wst.sse.core.INodeAdapter;
import org.eclipse.wst.sse.core.INodeNotifier;
import org.eclipse.wst.sse.core.internal.PropagatingAdapterFactory;
import org.eclipse.wst.xml.core.document.IDOMElement;
import org.eclipse.wst.xml.core.internal.propagate.PropagatingAdapterFactoryImpl;
import org.w3c.dom.Node;

public class PageDirectiveWatcherFactory extends PropagatingAdapterFactoryImpl implements PropagatingAdapterFactory {

	/**
	 * Constructor for PageDirectiveWatcherFactory.
	 */
	public PageDirectiveWatcherFactory() {
		this(PageDirectiveWatcher.class, true);
	}

	/**
	 * Constructor for PageDirectiveWatcherFactory.
	 * @param adapterKey
	 * @param registerAdapters
	 */
	public PageDirectiveWatcherFactory(Object adapterKey, boolean registerAdapters) {
		super(adapterKey, registerAdapters);
	}

	protected INodeAdapter createAdapter(INodeNotifier target) {
		PageDirectiveWatcher result = null;
		if (target instanceof IDOMElement) {
			IDOMElement xmlElement = (IDOMElement) target;
			if (xmlElement.getNodeType() == Node.ELEMENT_NODE) {
				//                if (xmlElement.getNodeName() == JSP12Namespace.ElementName.DIRECTIVE_PAGE) {   // not sure why identity to  JSP11Namespace.ElementName.DIRECTIVE_PAGE doesn't work
				String nodeName = xmlElement.getNodeName();
				if (nodeName.equals("jsp:directive.page")) { //$NON-NLS-1$
					result = new PageDirectiveWatcherImpl(xmlElement);
				}

			}
		}
		return result;

	}

	public IAdapterFactory copy() {
		return new PageDirectiveWatcherFactory(this.adapterKey, this.shouldRegisterAdapter);
	}
}
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
package org.eclipse.wst.html.core.cleanup;

import org.eclipse.core.runtime.Preferences;
import org.eclipse.wst.common.encoding.content.IContentTypeIdentifier;
import org.eclipse.wst.html.core.HTMLCorePlugin;
import org.eclipse.wst.html.core.format.HTMLFormatProcessorImpl;
import org.eclipse.wst.sse.core.cleanup.IStructuredCleanupHandler;
import org.eclipse.wst.sse.core.format.IStructuredFormatProcessor;
import org.eclipse.wst.xml.core.cleanup.CleanupProcessorXML;
import org.w3c.dom.Node;

public class HTMLCleanupProcessorImpl extends CleanupProcessorXML {

	/**
	 * @see com.ibm.sed.partitionCleanup.AbstractCleanupProcessorImpl#getContentType()
	 */
	protected String getContentType() {
		return IContentTypeIdentifier.ContentTypeID_HTML;
	}

	/**
	 * @see com.ibm.sed.partitionCleanup.AbstractCleanupProcessorImpl#getCleanupHandler(com.ibm.sed.model.xml.XMLNode)
	 */
	protected IStructuredCleanupHandler getCleanupHandler(Node node) {
		return HTMLCleanupHandlerFactory.getInstance().createHandler(node, getCleanupPreferences());
	}

	protected IStructuredFormatProcessor getFormatProcessor() {
		return new HTMLFormatProcessorImpl();
	}

	protected Preferences getModelPreferences() {
		return HTMLCorePlugin.getDefault().getPluginPreferences();
	}
}
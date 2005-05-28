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
package org.eclipse.wst.html.core.internal.cleanup;

import org.eclipse.core.runtime.Preferences;
import org.eclipse.wst.html.core.internal.HTMLCorePlugin;
import org.eclipse.wst.html.core.internal.format.HTMLFormatProcessorImpl;
import org.eclipse.wst.html.core.internal.provisional.contenttype.ContentTypeIdForHTML;
import org.eclipse.wst.sse.core.internal.cleanup.IStructuredCleanupHandler;
import org.eclipse.wst.sse.core.internal.format.IStructuredFormatProcessor;
import org.eclipse.wst.xml.core.internal.cleanup.CleanupProcessorXML;
import org.w3c.dom.Node;

public class HTMLCleanupProcessorImpl extends CleanupProcessorXML {

	protected String getContentType() {
		return ContentTypeIdForHTML.ContentTypeID_HTML;
	}

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
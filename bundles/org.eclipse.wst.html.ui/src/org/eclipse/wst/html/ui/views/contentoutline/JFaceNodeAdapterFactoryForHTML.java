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
package org.eclipse.wst.html.ui.views.contentoutline;



import org.eclipse.wst.sse.core.AdapterFactory;
import org.eclipse.wst.sse.core.INodeAdapter;
import org.eclipse.wst.sse.core.INodeNotifier;
import org.eclipse.wst.sse.ui.views.contentoutline.IJFaceNodeAdapter;
import org.eclipse.wst.xml.ui.views.contentoutline.JFaceNodeAdapterFactory;

/**
 * An adapter factory to create JFaceNodeAdapters.  Use this
 * adapter factory with a JFaceAdapterContentProvider to display
 * DOM nodes in a tree.
 */
public class JFaceNodeAdapterFactoryForHTML extends JFaceNodeAdapterFactory {


	public JFaceNodeAdapterFactoryForHTML() {
		this(IJFaceNodeAdapter.class, true);
	}

	public JFaceNodeAdapterFactoryForHTML(Object adapterKey, boolean registerAdapters) {
		super(adapterKey, registerAdapters);
	}

	protected INodeAdapter createAdapter(INodeNotifier node) {
		if (singletonAdapter == null) {
			// create the JFaceNodeAdapter
			singletonAdapter = new JFaceNodeAdapterForHTML(this);
			initAdapter(singletonAdapter, node);
		}
		return singletonAdapter;
	}

	public AdapterFactory copy() {
		return new JFaceNodeAdapterFactoryForHTML(this.adapterKey, this.shouldRegisterAdapter);
	}

}
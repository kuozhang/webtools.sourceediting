/*****************************************************************************
 * Copyright (c) 2004 IBM Corporation and others. All rights reserved. This
 * program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and
 * is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: IBM Corporation - initial API and implementation
 ****************************************************************************/
package org.eclipse.wst.css.ui.views.properties;

import org.eclipse.wst.sse.core.AbstractAdapterFactory;
import org.eclipse.wst.sse.core.INodeAdapter;
import org.eclipse.wst.sse.core.INodeNotifier;



//import com.ibm.sed.edit.xml.DOMPropertySource;
public class CSSPropertySourceAdapterFactory extends AbstractAdapterFactory {
	/**
	 * PropertySourceAdapterFactory constructor comment.
	 */
	public CSSPropertySourceAdapterFactory() {
		super();
	}

	/**
	 * PropertySourceAdapterFactory constructor comment.
	 * 
	 * @param adapterKey
	 *            java.lang.Object
	 * @param registerAdapters
	 *            boolean
	 */
	public CSSPropertySourceAdapterFactory(Object newAdapterKey, boolean newRegisterAdapters) {
		super(newAdapterKey, newRegisterAdapters);
	}

	/**
	 * createAdapter method comment.
	 */
	protected INodeAdapter createAdapter(INodeNotifier target) {
		// at the moment, only one implementation exists
		return new CSSPropertySource(target);
	}
}
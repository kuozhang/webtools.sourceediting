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
package org.eclipse.wst.html.core.htmlcss;



import java.util.StringTokenizer;

import org.eclipse.wst.css.core.adapters.IStyleSelectorAdapter;
import org.eclipse.wst.css.core.document.ICSSSimpleSelector;
import org.eclipse.wst.sse.core.INodeNotifier;
import org.w3c.dom.Element;

/**
 * Insert the type's description here.
 */
public class HTMLStyleSelectorAdapter implements IStyleSelectorAdapter {

	static private HTMLStyleSelectorAdapter instance;
	private Object toMatch = IStyleSelectorAdapter.class;

	/**
	 * Insert the method's description here.
	 * @return com.ibm.sed.model.html.css.HTMLStyleSelectorAdapter
	 */
	public synchronized static HTMLStyleSelectorAdapter getInstance() {
		if (instance == null) {
			instance = new HTMLStyleSelectorAdapter();
		}
		return instance;
	}

	/**
	 * @see com.ibm.sed.model.INodeAdapter
	 */
	public boolean isAdapterForType(Object type) {
		return type == toMatch;
	}

	/**
	 * @see com.ibm.sed.css.adapters.IStyleSelectorAdapter
	 */
	public boolean match(ICSSSimpleSelector selector, Element element, String pseudoName) {
		if (element == null)
			return false;
		int i;
		String key;

		// PseudoName
		i = selector.getNumOfPseudoNames();
		if (i > 0) {
			if (pseudoName == null || pseudoName.length() == 0)
				return false;
			for (i = i - 1; i >= 0; i--) {
				if (pseudoName.equalsIgnoreCase(selector.getPseudoName(i))) {
					break;
				}
			}
			if (i < 0)
				return false;
		}

		// check tag name
		if (!selector.isUniversal() && !element.getNodeName().equalsIgnoreCase(selector.getName()))
			return false;

		// check id
		i = selector.getNumOfIDs();
		if (i > 0) {
			if (i > 1)
				return false;
			key = element.getAttribute("id");//$NON-NLS-1$
			if (key == null)
				return false;
			if (!selector.getID(0).equals(key))
				return false;
		}

		// check class
		i = selector.getNumOfClasses();
		if (i > 0) {
			key = element.getAttribute("class");//$NON-NLS-1$
			if (key == null)
				return false;
			StringTokenizer tokenizer = new StringTokenizer(key);
			for (i = i - 1; i >= 0; i--) {
				boolean ok = false;
				while (tokenizer.hasMoreTokens()) {
					if (selector.getClass(i).equals(tokenizer.nextToken())) {
						ok = true;
						break;
					}
				}
				if (!ok)
					return false;
			}
		}

		// check attributes
		for (i = selector.getNumOfAttributes() - 1; i >= 0; i--) {
			StringTokenizer tokenizer = new StringTokenizer(selector.getAttribute(i), "=~| \t\r\n\f");//$NON-NLS-1$
			int countTokens = tokenizer.countTokens();
			if (countTokens > 0) {
				String attrValue = element.getAttribute(tokenizer.nextToken());
				if (attrValue == null)
					return false;
				if (countTokens > 1) {
					String token = tokenizer.nextToken("= \t\r\n\f");//$NON-NLS-1$
					StringTokenizer attrValueTokenizer = null;
					if (token.equals("~")) {//$NON-NLS-1$
						attrValueTokenizer = new StringTokenizer(attrValue);
					}
					else if (token.equals("|")) {//$NON-NLS-1$
						attrValueTokenizer = new StringTokenizer(attrValue, "-");//$NON-NLS-1$
					}
					if (attrValueTokenizer != null) {
						if (tokenizer.hasMoreTokens()) {
							token = tokenizer.nextToken();
							boolean ok = false;
							while (attrValueTokenizer.hasMoreTokens()) {
								if (token.equals(attrValueTokenizer.nextToken())) {
									ok = true;
									break;
								}
							}
							if (!ok)
								return false;
						}
					}
					else {
						if (!attrValue.equals(token))
							return false;
					}
				}
			}
		}

		return true;
	}

	/**
	 * @see com.ibm.sed.model.INodeAdapter
	 */
	public void notifyChanged(INodeNotifier notifier, int eventType, Object changedFeature, Object oldValue, Object newValue, int pos) {
	}
}
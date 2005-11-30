/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     
 *******************************************************************************/
package org.eclipse.jst.jsp.core.taglib;

import java.net.URL;

/**
 * A record representing a .tld that is not a standalone file
 * <p>
 * This interface is not intended to be implemented by clients.
 * </p>
 * 
 * @since 1.0
 */
public interface IURLRecord extends ITaglibRecord {

	String getBaseLocation();

	/**
	 * @return Returns the short-name (normally treated as the
	 *         recommended/default prefix), if one was specified within this
	 *         TLD's contents.
	 */
	String getShortName();

	/**
	 * @return Returns the uri specified within this TLD's contents.
	 */
	String getURI();

	/**
	 * @return Returns the URL to this TLD's contents.
	 */
	URL getURL();
}

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
package org.eclipse.jst.jsp.core.internal.contenttype;

import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.wst.sse.core.internal.encoding.ICodedResourcePlugin;


public interface IContentDescriptionForJSP {
	/**
	 * This should not be considered API at this point. It should probably be
	 * moved in future.
	 */
	public final static QualifiedName CONTENT_TYPE_ATTRIBUTE = new QualifiedName(ICodedResourcePlugin.ID, "contentTypeAttribute"); //$NON-NLS-1$
	public final static QualifiedName LANGUAGE_ATTRIBUTE = new QualifiedName(ICodedResourcePlugin.ID, "languageAttribute"); //$NON-NLS-1$

}
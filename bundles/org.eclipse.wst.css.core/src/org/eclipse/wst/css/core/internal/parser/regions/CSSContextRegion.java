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
package org.eclipse.wst.css.core.internal.parser.regions;

import org.eclipse.wst.sse.core.internal.parser.ContextRegion;

public class CSSContextRegion extends ContextRegion {
	public CSSContextRegion(String context, int start, int textLength, int length) {
		fType = context;
		fStart = start;
		fTextLength = textLength;
		fLength = length;
	}

}
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
package org.eclipse.wst.html.core.internal.contenttype;

import org.eclipse.core.runtime.content.ITextContentDescriber;
import org.eclipse.wst.common.encoding.AbstractContentDescriber;
import org.eclipse.wst.common.encoding.IResourceCharsetDetector;


public class ContentDescriberForHTML extends AbstractContentDescriber implements ITextContentDescriber {


	protected IResourceCharsetDetector getDetector() {
		return new HTMLResourceEncodingDetector();
	}

}
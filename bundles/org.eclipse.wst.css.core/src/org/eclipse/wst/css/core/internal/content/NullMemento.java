/*******************************************************************************
 * Copyright (c) 2001, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Jens Lukowski/Innoopract - initial renaming/restructuring
 *     
 *******************************************************************************/
package org.eclipse.wst.css.core.internal.content;

import org.eclipse.wst.common.encoding.EncodingMemento;
import org.eclipse.wst.common.encoding.NonContentBasedEncodingRules;



/**
 * This class can be used in place of an EncodingMemento (its super class),
 * when there is not in fact ANY encoding information. For example, when a
 * structuredDocument is created directly from a String
 */
public class NullMemento extends EncodingMemento {
	/**
	 *  
	 */
	public NullMemento() {
		super();
		String defaultCharset = NonContentBasedEncodingRules.useDefaultNameRules(null);
		setJavaCharsetName(defaultCharset);
		setAppropriateDefault(defaultCharset);
		setDetectedCharsetName(null);
		addTrace(DEFAULTS_ASSUMED_FOR_EMPTY_INPUT);
	}

}

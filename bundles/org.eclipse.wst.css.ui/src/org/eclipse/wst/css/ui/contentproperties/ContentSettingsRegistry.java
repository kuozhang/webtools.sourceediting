/*****************************************************************************
 * Copyright (c) 2004 IBM Corporation and others. All rights reserved. This
 * program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and
 * is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: IBM Corporation - initial API and implementation
 ****************************************************************************/
package org.eclipse.wst.css.ui.contentproperties;

import java.util.Iterator;

import org.eclipse.wst.css.core.metamodel.CSSProfile;
import org.eclipse.wst.css.core.metamodel.CSSProfileRegistry;
import org.eclipse.wst.sse.ui.contentproperties.ui.ComboList;
import org.eclipse.wst.sse.ui.nls.ResourceHandler;

public final class ContentSettingsRegistry {
	private static final String NONE = ResourceHandler.getString("UI_none"); //$NON-NLS-1$

	public static void setCSSMetaModelRegistryInto(ComboList combo) {
		combo.add(NONE, ""); //$NON-NLS-1$
		CSSProfileRegistry reg = CSSProfileRegistry.getInstance();
		Iterator i = reg.getProfiles();
		while (i.hasNext()) {
			CSSProfile profile = (CSSProfile) i.next();
			String id = profile.getProfileID();
			String name = profile.getProfileName();
			combo.add(name, id);
		}
		combo.sortByKey(1);
	}

}
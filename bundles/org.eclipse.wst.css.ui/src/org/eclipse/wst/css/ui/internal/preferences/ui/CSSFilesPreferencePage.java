/*****************************************************************************
 * Copyright (c) 2004 IBM Corporation and others. All rights reserved. This
 * program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and
 * is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: IBM Corporation - initial API and implementation
 ****************************************************************************/
package org.eclipse.wst.css.ui.internal.preferences.ui;

import org.eclipse.core.runtime.Preferences;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.help.WorkbenchHelp;
import org.eclipse.wst.css.core.internal.CSSCorePlugin;
import org.eclipse.wst.css.ui.internal.CSSUIPlugin;
import org.eclipse.wst.css.ui.internal.editor.IHelpContextIds;
import org.eclipse.wst.xml.ui.internal.preferences.XMLFilesPreferencePage;

public class CSSFilesPreferencePage extends XMLFilesPreferencePage {
	protected IPreferenceStore doGetPreferenceStore() {
		return CSSUIPlugin.getDefault().getPreferenceStore();
	}

	protected void doSavePreferenceStore() {
		CSSCorePlugin.getDefault().savePluginPreferences(); // model
	}

	protected Preferences getModelPreferences() {
		return CSSCorePlugin.getDefault().getPluginPreferences();
	}

	protected Control createContents(Composite parent) {
		Control c = super.createContents(parent);
		WorkbenchHelp.setHelp(c, IHelpContextIds.CSS_PREFWEBX_FILES_HELPID);
		return c;
	}
}
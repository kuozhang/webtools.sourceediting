/*****************************************************************************
 * Copyright (c) 2004 IBM Corporation and others. All rights reserved. This
 * program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and
 * is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: IBM Corporation - initial API and implementation
 ****************************************************************************/
package org.eclipse.wst.css.ui.edit.ui;

import java.util.ResourceBundle;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.wst.css.core.cleanup.CleanupProcessorCSS;
import org.eclipse.wst.sse.core.cleanup.IStructuredCleanupProcessor;
import org.eclipse.wst.sse.ui.edit.util.CleanupAction;

public class CleanupActionCSS extends CleanupAction {
	protected IStructuredCleanupProcessor fCleanupProcessor;

	public CleanupActionCSS(ResourceBundle bundle, String prefix, ITextEditor editor) {
		super(bundle, prefix, editor);
	}

	protected Dialog getCleanupDialog(Shell shell) {
		if (fCleanupDialog == null)
			fCleanupDialog = new CleanupDialogCSS(shell);

		return fCleanupDialog;
	}

	protected IStructuredCleanupProcessor getCleanupProcessor() {
		if (fCleanupProcessor == null)
			fCleanupProcessor = new CleanupProcessorCSS();

		return fCleanupProcessor;
	}
}
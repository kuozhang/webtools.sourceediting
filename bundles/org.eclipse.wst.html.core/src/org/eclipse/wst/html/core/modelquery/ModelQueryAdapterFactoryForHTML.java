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
package org.eclipse.wst.html.core.modelquery;



import org.eclipse.wst.common.contentmodel.modelquery.ModelQuery;
import org.eclipse.wst.common.contentmodel.util.CMDocumentCache;
import org.eclipse.wst.sse.core.AbstractAdapterFactory;
import org.eclipse.wst.sse.core.AdapterFactory;
import org.eclipse.wst.sse.core.IModelStateListener;
import org.eclipse.wst.sse.core.INodeAdapter;
import org.eclipse.wst.sse.core.INodeNotifier;
import org.eclipse.wst.sse.core.IStructuredModel;
import org.eclipse.wst.sse.core.modelquery.ModelQueryAdapter;
import org.eclipse.wst.sse.core.modelquery.ModelQueryAdapterImpl;
import org.eclipse.wst.sse.core.util.Debug;
import org.eclipse.wst.xml.core.document.XMLNode;
import org.eclipse.wst.xml.core.modelquery.XMLCatalogIdResolver;
import org.eclipse.wst.xml.uriresolver.util.IdResolver;

/**
 * Creates a ModelQueryAdapter for HTML models
 */
public class ModelQueryAdapterFactoryForHTML extends AbstractAdapterFactory implements IModelStateListener {

	protected ModelQueryAdapterImpl modelQueryAdapterImpl;
	protected IStructuredModel stateNotifier = null;

	/**
	 * ModelQueryAdapterFactoryForHTML constructor comment.
	 */
	public ModelQueryAdapterFactoryForHTML() {
		this(ModelQueryAdapter.class, true);
	}

	/**
	 * ModelQueryAdapterFactoryForHTML constructor comment.
	 * @param adapterKey java.lang.Object
	 * @param registerAdapters boolean
	 */
	public ModelQueryAdapterFactoryForHTML(Object adapterKey, boolean registerAdapters) {
		super(adapterKey, registerAdapters);
	}

	/**
	 * createAdapter method comment.
	 */
	protected INodeAdapter createAdapter(INodeNotifier target) {

		if (Debug.displayInfo)
			System.out.println("-----------------------ModelQueryAdapterFactoryForHTML.createAdapter" + target); //$NON-NLS-1$
		if (modelQueryAdapterImpl == null) {
			if (target instanceof XMLNode) {
				XMLNode xmlNode = (XMLNode) target;
				IStructuredModel model = stateNotifier = xmlNode.getModel();
				stateNotifier.addModelStateListener(this);
				String baseLocation = model.getBaseLocation();
				if (Debug.displayInfo)
					System.out.println("----------------ModelQueryAdapterFactoryForHTML... baseLocation : " + baseLocation); //$NON-NLS-1$

				CMDocumentCache cmDocumentCache = new CMDocumentCache();
				IdResolver idResolver = new XMLCatalogIdResolver(baseLocation, model.getResolver());
				ModelQuery modelQuery = new HTMLModelQueryImpl(cmDocumentCache, idResolver);
				modelQuery.setEditMode(ModelQuery.EDIT_MODE_UNCONSTRAINED);
				modelQueryAdapterImpl = new ModelQueryAdapterImpl(cmDocumentCache, modelQuery, idResolver);
			}
		}
		return modelQueryAdapterImpl;
	}

	protected void updateResolver(IStructuredModel model) {
		modelQueryAdapterImpl.setIdResolver(new XMLCatalogIdResolver(model.getBaseLocation(), model.getResolver()));
	}

	/**
	 * @see IModelStateListener#modelAboutToBeChanged(IStructuredModel)
	 */
	public void modelAboutToBeChanged(IStructuredModel model) {
	}

	/**
	 * @see IModelStateListener#modelChanged(IStructuredModel)
	 */
	public void modelChanged(IStructuredModel model) {
	}

	/**
	 * @see IModelStateListener#modelDirtyStateChanged(IStructuredModel, boolean)
	 */
	public void modelDirtyStateChanged(IStructuredModel model, boolean isDirty) {
	}

	/**
	 * @see IModelStateListener#modelResourceDeleted(IStructuredModel)
	 */
	public void modelResourceDeleted(IStructuredModel model) {
	}

	/**
	 * @see IModelStateListener#modelResourceMoved(IStructuredModel, IStructuredModel)
	 */
	public void modelResourceMoved(IStructuredModel oldModel, IStructuredModel newModel) {
		stateNotifier.removeModelStateListener(this);
		stateNotifier = newModel;
		updateResolver(stateNotifier);
		stateNotifier.addModelStateListener(this);
	}

	public void release() {
		super.release();
		if (stateNotifier != null)
			stateNotifier.removeModelStateListener(this);
		stateNotifier = null;
		if (modelQueryAdapterImpl != null)
			modelQueryAdapterImpl.release();
	}

	public AdapterFactory copy() {

		return new ModelQueryAdapterFactoryForHTML(this.adapterKey, this.shouldRegisterAdapter);
	}
}
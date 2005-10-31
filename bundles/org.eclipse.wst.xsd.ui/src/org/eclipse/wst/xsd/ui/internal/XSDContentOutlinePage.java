/*******************************************************************************
 * Copyright (c) 2001, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.wst.xsd.ui.internal;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.ListenerList;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IPostSelectionProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.eclipse.wst.xsd.ui.internal.actions.OpenSchemaAction;
import org.eclipse.wst.xsd.ui.internal.provider.CategoryAdapter;
import org.eclipse.xsd.XSDConcreteComponent;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSchemaDirective;
import org.w3c.dom.Element;

/**
 * @deprecated Using SSE's ConfiguratbleContentOutlinePage 
 * instead via XSDContentOutlineCOnfiguration
 */
public class XSDContentOutlinePage extends ContentOutlinePage implements ISelectionListener
{
  protected XSDEditor xsdEditor;
  protected int level = 0;
  protected Object model;
  protected ITreeContentProvider contentProvider;
  protected ILabelProvider labelProvider;
  protected XSDSelectionManager selectionManager;
  protected SelectionManagerSelectionChangeListener selectionManagerSelectionChangeListener = new SelectionManagerSelectionChangeListener();
  protected TreeSelectionChangeListener treeSelectionChangeListener = new TreeSelectionChangeListener();
  XSDEditor xsdTextEditor;
  XSDMenuListener menuListener;
  SelectionProvider fSelectionProvider = null;
  
  /**
   *  
   */
  public XSDContentOutlinePage(XSDEditor xsdTextEditor)
  {
    super();
    this.xsdTextEditor = xsdTextEditor;
    fSelectionProvider = new SelectionProvider();
  }

  public void init(IPageSite pageSite)
  {
  	super.init(pageSite);
  	getSite().getWorkbenchWindow().getSelectionService().addPostSelectionListener(this);
  	getSite().setSelectionProvider(fSelectionProvider);
  }
  
  public void dispose()
  {
  	super.dispose();
  	getSite().getWorkbenchWindow().getSelectionService().removePostSelectionListener(this);
  }
  
  public void setModel(Object newModel)
  {
    model = newModel;
  }

  public void setContentProvider(ITreeContentProvider contentProvider)
  {
    this.contentProvider = contentProvider;
  }

  public void setLabelProvider(ILabelProvider labelProvider)
  {
    this.labelProvider = labelProvider;
  }

  // expose
  public TreeViewer getTreeViewer()
  {
    return super.getTreeViewer();
  }

  public void createControl(Composite parent)
  {
    super.createControl(parent);
    getTreeViewer().setContentProvider(contentProvider);
    getTreeViewer().setLabelProvider(labelProvider);
    getTreeViewer().setInput(model);
//    getTreeViewer().addSelectionChangedListener(this);
    MenuManager menuManager = new MenuManager("#popup");//$NON-NLS-1$
    menuManager.setRemoveAllWhenShown(true);
    Menu menu = menuManager.createContextMenu(getTreeViewer().getControl());
    getTreeViewer().getControl().setMenu(menu);
    menuListener = new XSDMenuListener(xsdTextEditor.getSelectionManager());
//  menuListener.setSelectionProvider(getTreeViewer());
    menuManager.addMenuListener(menuListener);
    
    // enable popupMenus extension
    getSite().registerContextMenu("org.eclipse.wst.xsd.ui.popup.outline", menuManager, xsdTextEditor.getSelectionManager());

    setSelectionManager(xsdTextEditor.getSelectionManager());
    // cs... why are we doing this from the outline view?
    //
    //xsdTextEditor.getXSDEditor().getSelectionManager().setSelection(new
    // StructuredSelection(xsdTextEditor.getXSDSchema()));
    XSDKeyListener keyListener = new XSDKeyListener(getTreeViewer(), menuListener);
    getTreeViewer().getControl().addKeyListener(keyListener);
    // drill down from outline view
    getTreeViewer().getControl().addMouseListener(new MouseAdapter()
    {
      public void mouseDoubleClick(MouseEvent e)
      {
        ISelection iSelection = getTreeViewer().getSelection();
        if (iSelection instanceof StructuredSelection)
        {
          StructuredSelection selection = (StructuredSelection)iSelection;
          Object obj = selection.getFirstElement();
          if (obj instanceof XSDConcreteComponent)
          {
            XSDConcreteComponent comp = (XSDConcreteComponent)obj;
            if (comp.getContainer() instanceof XSDSchema)
            {
              xsdTextEditor.getGraphViewer().setInput(obj);
            }
          }
        }

      }
    });
    
    
		getTreeViewer().addPostSelectionChangedListener(fSelectionProvider.getPostSelectionChangedListener());
		getTreeViewer().addSelectionChangedListener(fSelectionProvider.getSelectionChangedListener());

  }
  class XSDKeyListener extends KeyAdapter
  {
    TreeViewer viewer;
    XSDMenuListener menuListener;

    public XSDKeyListener(TreeViewer viewer, XSDMenuListener menuListener)
    {
      super();
      this.viewer = viewer;
      this.menuListener = menuListener;
    }

    /**
     * @see org.eclipse.swt.events.KeyAdapter#keyReleased(KeyEvent)
     */
    public void keyReleased(KeyEvent e)
    {
      if (e.character == SWT.DEL)
      {
        menuListener.getDeleteAction().run();
      }
      else if (e.keyCode == SWT.F3) // open editor on any
                                    // include/import/redefine
      {
        if (e.widget instanceof Tree)
        {
          Tree tree = (Tree) e.widget;
          TreeItem[] selection = tree.getSelection();
          if (selection.length > 0)
          {
            if (selection[0].getData() instanceof XSDSchemaDirective)
            {
              XSDSchemaDirective comp = (XSDSchemaDirective) selection[0].getData();
              OpenSchemaAction openSchema = new OpenSchemaAction(XSDEditorPlugin.getXSDString("_UI_ACTION_OPEN_SCHEMA"), comp);
              openSchema.run();
            }
          }
        }
      }
    }
  }

  public void setExpandToLevel(int i)
  {
    level = i;
  }

  public void setInput(Object value)
  {
    getTreeViewer().setInput(value);
    getTreeViewer().expandToLevel(level);
  }

  public void selectionChanged(IWorkbenchPart part, ISelection selection)
  {
    if (selectionManager != null)
    {
      if (selection instanceof IStructuredSelection)
      {
        IStructuredSelection structuredSelection = (IStructuredSelection) selection;
        Object o = structuredSelection.getFirstElement();
        // TODO ...
        // we need to implement a selectionManagerMapping extension point
        // so that extensions can specify how they'd like to map view objects
        // to selection objects
        //                                        
        if (o instanceof Element)
        {
          try
          {
            Object modelObject = xsdTextEditor.getXSDSchema().getCorrespondingComponent((Element) o);
            if (modelObject != null)
            {
              o = modelObject;
            }
          }
          catch (Exception e)
          {
          }
        }
        else if (o instanceof CategoryAdapter)
        {
          // todo... we need to ensure we eliminate the propagation 
          // of 'view' specific objects into the SelectionManager.                     
          // We need to do some work to ensure all views utilize the 'Category' model object  
          // so we can get rid of this CategoryAdapter class.
//           CategoryAdapter adapter = (CategoryAdapter) o;
//           o = adapter.getXSDSchema();
        }
        if (o != null)
        {
    			if (getControl() != null && !getControl().isDisposed() && !getControl().isFocusControl() && getControl().isVisible()) {
    				/*
    				 * Do not allow selection from other parts to affect selection
    				 * in the tree widget if it has focus. Selection events
    				 * "bouncing" off of other parts are all that we can receive
    				 * if we have focus (since we forward selection to the
    				 * service), and only the user should affect selection if we
    				 * have focus.
    				 */
            getTreeViewer().setSelection(new StructuredSelection(o), true);
    			}
          selectionManager.setSelection(new StructuredSelection(o), getTreeViewer());
//        selectionManager.selectionChanged(new SelectionChangedEvent(getTreeViewer(),new StructuredSelection(o)));
        }
        else
        {
          // selectionManager.setSelection(new StructuredSelection(),
          // getTreeViewer());
        }
      }
    }
  }
  
  public void setSelectionManager(XSDSelectionManager newSelectionManager)
  {
    TreeViewer treeViewer = getTreeViewer();
    // disconnect from old one
    if (selectionManager != null)
    {
      selectionManager.removeSelectionChangedListener(selectionManagerSelectionChangeListener);
      treeViewer.removeSelectionChangedListener(treeSelectionChangeListener);
    }
    selectionManager = newSelectionManager;
    // connect to new one
    if (selectionManager != null)
    {
      selectionManager.addSelectionChangedListener(selectionManagerSelectionChangeListener);
      treeViewer.addSelectionChangedListener(treeSelectionChangeListener);
    }
  }
  
  class SelectionManagerSelectionChangeListener implements ISelectionChangedListener
  {
    public void selectionChanged(SelectionChangedEvent event)
    {
      if (event.getSelectionProvider() != getTreeViewer())
      {
        getTreeViewer().setSelection(event.getSelection(), true);
      }
    }
  }
  class TreeSelectionChangeListener implements ISelectionChangedListener
  {
    public void selectionChanged(SelectionChangedEvent event)
    {
      if (selectionManager != null)
      {
        ISelection selection = event.getSelection();
        if (selection instanceof IStructuredSelection)
        {
          IStructuredSelection structuredSelection = (IStructuredSelection) selection;
          Object o = structuredSelection.getFirstElement();
          // TODO ...
          // we need to implement a selectionManagerMapping extension point
          // so that extensions can specify how they'd like to map view objects
          // to selection objects
          //                                        
          if (o instanceof Element)
          {
            try
            {
              Object modelObject = xsdTextEditor.getXSDSchema().getCorrespondingComponent((Element) o);
              if (modelObject != null)
              {
                o = modelObject;
              }
            }
            catch (Exception e)
            {
            }
          }
          else if (o instanceof CategoryAdapter)
          {
            // todo... we need to ensure we eliminate the propagation 
            // of 'view' specific objects into the SelectionManager.                     
            // We need to do some work to ensure all views utilize the 'Category' model object  
            // so we can get rid of this CategoryAdapter class.
//             CategoryAdapter adapter = (CategoryAdapter) o;
//             o = adapter.getXSDSchema();
          }
          if (o != null)
          {
            selectionManager.setSelection(new StructuredSelection(o), getTreeViewer());
//          selectionManager.selectionChanged(new SelectionChangedEvent(getTreeViewer(),new StructuredSelection(o)));
          }
        }
      }
    }
  }
  FilterAction referenceAction, inheritedAction;

  public void setActionBars(IActionBars actionBars)
  {
    super.setActionBars(actionBars);
    // Uncomment to add sort action
    //    SortAction sortAction = new SortAction();
    //
    //    actionBars.getToolBarManager().add(sortAction);
    //    sortAction.setChecked(false);
    referenceAction = new FilterAction(new ReferenceFilter("Reference Content"), XSDEditorPlugin.getXSDString("_UI_OUTLINE_SHOW_REFERENCES"), ImageDescriptor.createFromFile(XSDEditorPlugin
        .getPlugin().getClass(), "icons/XSDElementRef.gif"));
    boolean initialRef = xsdTextEditor.getXSDModelAdapterFactory().getShowReferences();
    referenceAction.setChecked(initialRef);
    inheritedAction = new FilterAction(new ReferenceFilter("Inherited Content"), XSDEditorPlugin.getXSDString("_UI_OUTLINE_SHOW_INHERITED"), ImageDescriptor.createFromFile(XSDEditorPlugin.getPlugin()
        .getClass(), "icons/XSDComplexContent.gif"));
    IMenuManager menu = actionBars.getMenuManager();
    menu.add(referenceAction);
    menu.add(inheritedAction);
  }

  private void updateActions(Action current)
  {
    if (referenceAction.isChecked())
    {
      xsdTextEditor.getXSDModelAdapterFactory().setShowReferences(true);
    }
    else
    {
      xsdTextEditor.getXSDModelAdapterFactory().setShowReferences(false);
    }
    if (inheritedAction.isChecked())
    {
      xsdTextEditor.getXSDModelAdapterFactory().setShowInherited(true);
    }
    else
    {
      xsdTextEditor.getXSDModelAdapterFactory().setShowInherited(false);
    }
  }
  private Sorter sorter = new Sorter();
  public class Sorter extends org.eclipse.jface.viewers.ViewerSorter
  {
  }
  public class SortAction extends Action
  {
    public SortAction()
    {
      super("Sort", ImageDescriptor.createFromFile(XSDEditorPlugin.getPlugin().getClass(), "icons/sort.gif"));
    }

    public void run()
    {
      getTreeViewer().getControl().setVisible(false);
      Object[] expandedElements = getTreeViewer().getExpandedElements();
      getTreeViewer().setSorter(isChecked() ? sorter : null);
      Object input = getTreeViewer().getInput();
      getTreeViewer().setInput(input);
      getTreeViewer().setExpandedElements(expandedElements);
      getTreeViewer().getControl().setVisible(true);
    }

    public void setChecked(boolean checked)
    {
      super.setChecked(checked);
      setToolTipText(checked ? XSDEditorPlugin.getXSDString("_UI_OUTLINE_DO_NOT_SORT") : XSDEditorPlugin.getXSDString("_UI_OUTLINE_SORT"));
    }
  }
  public class FilterAction extends Action
  {
    ViewerFilter filter;

    public FilterAction(ViewerFilter filter, String label, ImageDescriptor image)
    {
      super(label, image);
      this.filter = filter;
      setChecked(false);
    }

    public void run()
    {
      updateActions(this);
      if (isChecked())
      {
        getTreeViewer().resetFilters();
        getTreeViewer().addFilter(filter);
      }
      else
      {
        getTreeViewer().removeFilter(filter);
      }
    }
  }
  class ReferenceFilter extends ViewerFilter // Dummy filter
  {
    public ReferenceFilter(String elementTag)
    {
      this.elementTag = elementTag;
    }
    protected String elementTag;

    public boolean select(Viewer viewer, Object parentElement, Object element)
    {
      return true;
    }
  }
  
	/**
	 * Forwards post-selection from the tree viewer to the listeners while
	 * acting as this page's selection provider.
	 */
	private class SelectionProvider implements IPostSelectionProvider {
		private class PostSelectionChangedListener implements ISelectionChangedListener {
			public void selectionChanged(SelectionChangedEvent event) {
				if (!isFiringSelection()) {
					fireSelectionChanged(event, postListeners);
				}
			}
		}

		private class SelectionChangedListener implements ISelectionChangedListener {
			public void selectionChanged(SelectionChangedEvent event) {
				if (!isFiringSelection()) {
					fireSelectionChanged(event, listeners);
				}
			}
		}

		private boolean isFiringSelection = false;
		private ListenerList listeners = new ListenerList();
		private ListenerList postListeners = new ListenerList();
		private ISelectionChangedListener postSelectionChangedListener = new PostSelectionChangedListener();
		private ISelectionChangedListener selectionChangedListener = new SelectionChangedListener();

		public void addPostSelectionChangedListener(ISelectionChangedListener listener) {
			postListeners.add(listener);
		}

		public void addSelectionChangedListener(ISelectionChangedListener listener) {
			listeners.add(listener);
		}

		public void fireSelectionChanged(final SelectionChangedEvent event, ListenerList listenerList) {
			isFiringSelection = true;
			Object[] listeners = listenerList.getListeners();
			for (int i = 0; i < listeners.length; ++i) {
				final ISelectionChangedListener l = (ISelectionChangedListener) listeners[i];
				Platform.run(new SafeRunnable() {
					public void run() {
						l.selectionChanged(event);
					}
				});
			}
			isFiringSelection = false;
		}

		public void fireSelectionChanged(final SelectionChangedEvent event) {
			isFiringSelection = true;
			Object[] listeners = postListeners.getListeners();
			for (int i = 0; i < listeners.length; ++i) {
				final ISelectionChangedListener l = (ISelectionChangedListener) listeners[i];
				Platform.run(new SafeRunnable() {
					public void run() {
						l.selectionChanged(event);
					}
				});
			}
			isFiringSelection = false;
		}

		public ISelectionChangedListener getPostSelectionChangedListener() {
			return postSelectionChangedListener;
		}

		public ISelection getSelection() {
			if (getTreeViewer() != null) {
				return getTreeViewer().getSelection();
			}
			return StructuredSelection.EMPTY;
		}

		public ISelectionChangedListener getSelectionChangedListener() {
			return selectionChangedListener;
		}

		public boolean isFiringSelection() {
			return isFiringSelection;
		}

		public void removePostSelectionChangedListener(ISelectionChangedListener listener) {
			postListeners.remove(listener);
		}

		public void removeSelectionChangedListener(ISelectionChangedListener listener) {
			listeners.remove(listener);
		};

		public void setSelection(ISelection selection) {
			if (isFiringSelection) {
				getTreeViewer().setSelection(selection);
			}
		};
	}

}
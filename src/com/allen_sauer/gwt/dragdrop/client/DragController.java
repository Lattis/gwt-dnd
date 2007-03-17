/*
 * Copyright 2007 Fred Sauer
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.allen_sauer.gwt.dragdrop.client;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Widget;

import com.allen_sauer.gwt.dragdrop.client.drop.BoundaryDropController;
import com.allen_sauer.gwt.dragdrop.client.drop.DropController;

/**
 * Interface which implementing drag controllers much implement.
 * 
 * <p>Be sure to also create one or more
 * {@link com.allen_sauer.gwt.dragdrop.client.drop.DropController DropControllers}
 * and {@link #registerDropController(DropController) register} them.</p>
 */
public interface DragController extends FiresDragEvents {

  void addDragHandler(DragHandler handler);

  /**
   * Call back method for {@link MouseDragHandler}.
   * 
   * @param draggable widget which was being dragged
   * @param dropTarget widget on which draggable was dropped. 
   *        <code>null</code> if drag was canceled
   */
  void dragEnd(Widget draggable, Widget dropTarget);

  /**
   * Call back method for {@link MouseDragHandler}.
   * 
   * @param draggable widget which was being dragged
   */
  void dragStart(Widget draggable);

  /**
   * Get the boundary panel provided in the constructor.
   * 
   * @return the AbsolutePanel provided in the constructor
   */
  AbsolutePanel getBoundaryPanel();

  /**
   * Determine which DropController represents the drop target which
   * is currently engaging the drag proxy, meaning the drop target
   * and proxy widgets overlap and the drop target has no descendant
   * drop targets which also intersect
   * 
   * @param draggableProxy the proxy widget to be used as a reference
   * @return the repsonsibile DropController
   */
  DropController getIntersectDropController(Widget draggableProxy);

  /**
   * @return widget which will move as part of the drag operation.
   *         May be the actual draggable widget or an appropriate proxy widget.
   */
  Widget getMovableWidget();

  /**
   * Enable dragging on widget.
   * 
   * @see AbstractDragController#makeDraggable(Widget)
   * 
   * @param widget the widget to be made draggable
   */
  void makeDraggable(Widget widget);

  /**
   * Enable dragging on widget, but specify a specific child widget
   * as the drag handle.
   * 
   * @see AbstractDragController#makeDraggable(Widget, Widget)
   * 
   * @param draggable the widget to be made draggable
   * @param dragHandle the widget by which widget can be dragged
   */
  void makeDraggable(Widget draggable, Widget dragHandle);

  /**
   * Performs the reverse of {@link #makeDraggable(Widget)}, making the
   * widget no longer draggable by this drag controller.
   * 
   * @param widget the widget to be made no longer draggable
   */
  void makeNotDraggable(Widget widget);

  /**
   * Create a new BoundaryDropController to manage our boundary panel as a
   * drop target.
   * 
   * @param boundaryPanel the panel to which our drag-and-drop operations are constrained
   * @return the new DropController
   */
  BoundaryDropController newBoundaryDropController(AbsolutePanel boundaryPanel);

  /**
   * Call back method for {@link MouseDragHandler}.
   * 
   * @param draggable widget which was being dragged
   * @param dropTarget widget on which draggable was dropped. 
   *        <code>null</code> if drag was canceled
   */
  void notifyDragEnd(Widget draggable, Widget dropTarget);

  /**
   * Call back method for {@link MouseDragHandler}.
   * 
   * @param draggable widget which was being dragged
   * @throws VetoDragException if the proposed operation is unacceptable
   */
  void previewDragEnd(Widget draggable, Widget dropTarget) throws VetoDragException;

  /**
   * Call back method for {@link MouseDragHandler}.
   * 
   * @param draggable widget which was being dragged
   * @throws VetoDragException if the proposed operation is unacceptable
   */
  void previewDragStart(Widget draggable) throws VetoDragException;

  /**
   * Register a new DropController, representing a new drop target,
   * with this drag controller.
   * 
   * @param dropController the controller to register
   */
  void registerDropController(DropController dropController);

  void removeDragHandler(DragHandler handler);

  void resetCache();

  /**
   * Restore the draggable to its original location
   * 
   * @see #saveDraggableLocation(Widget)
   * 
   * @param draggable the widget to be restored to its original location
   */
  void restoreDraggableLocation(Widget draggable);

  /**
   * Save the draggable's current location in case we need to
   * restore it later.
   * 
   * @see #restoreDraggableLocation(Widget)
   * 
   * @param draggable the widget for which the location must be saved
   */
  void saveDraggableLocation(Widget draggable);
}
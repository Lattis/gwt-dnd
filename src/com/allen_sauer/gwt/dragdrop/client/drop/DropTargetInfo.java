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
package com.allen_sauer.gwt.dragdrop.client.drop;

import com.google.gwt.user.client.ui.AbsolutePanel;

import com.allen_sauer.gwt.dragdrop.client.util.UIUtil;

public final class DropTargetInfo {

  private final AbsolutePanel dropTarget;
  private AbsolutePanel boundaryPanel;
  private int dropAreaClientWidth;
  private int dropAreaClientHeight;

  public DropTargetInfo(AbsolutePanel dropTarget) {
    this.dropTarget = dropTarget;
  }

  public final AbsolutePanel getBoundaryPanel() {
    return this.boundaryPanel;
  }

  public final int getDropAreaClientHeight() {
    if (dropAreaClientHeight == 0) {
      dropAreaClientHeight = UIUtil.getClientHeight(dropTarget.getElement());
    }
    return this.dropAreaClientHeight;
  }

  public final int getDropAreaClientWidth() {
    if (dropAreaClientWidth == 0) {
      dropAreaClientWidth = UIUtil.getClientWidth(dropTarget.getElement());
    }
    return this.dropAreaClientWidth;
  }

  public final AbsolutePanel getDropTarget() {
    return this.dropTarget;
  }

  public final void setBoundaryPanel(AbsolutePanel boundaryPanel) {
    this.boundaryPanel = boundaryPanel;
  }
}

/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package settings;

import ui.support.Frame;
import controller.Controller;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

/**
 *
 * @author Ivantha
 */
public class SettingsController implements Controller{
    private final Settings view = new Settings();

    public SettingsController() {
        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                SettingsController.this.updateView();
            }
        });
    }

    @Override
    public void showView() {
        Frame.showInternalFrame(view);
    }

    @Override
    public void updateView() {}

    @Override
    public void clearView() {}
    
}

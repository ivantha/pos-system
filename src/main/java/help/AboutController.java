/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package help;

import ui.support.Frame;
import java.awt.event.ActionEvent;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import controller.Controller;

/**
 *
 * @author Ivantha
 */
public class AboutController implements Controller{
    private final About view = new About();

    public AboutController() {
        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                AboutController.this.updateView();
            }
        });
        
        //Close button
        view.addCloseButtonActionListener((ActionEvent e) -> {
            view.dispose();
        });
    }
    
    @Override
    public void showView(){
        //view.setBorder(null);
        Frame.showInternalFrameAtCentre(view);
        view.setUI(null);
    }

    @Override
    public void updateView() {}

    @Override
    public void clearView() {}
}

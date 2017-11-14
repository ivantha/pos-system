/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package ui.support;

import main.DashboardController;
import java.awt.Dimension;
import javax.swing.JInternalFrame;
import controller.ControllerFactory;

/**
 *
 * @author Ivantha
 */
public class Frame {  
    private static final DashboardController dashboard = (DashboardController) ControllerFactory.getController(controller.Interface.DASHBOARD);
    
    public static void showInternalFrame(JInternalFrame frame){
        dashboard.addFrame(frame);
        Info.clear();
        
        Dimension jDesktopPaneSize = dashboard.getJDesktopPaneSize();
        Dimension jInternalFrameSize = frame.getSize();
        int width = (jDesktopPaneSize.width - jInternalFrameSize.width) / 4;
        int height = (jDesktopPaneSize.height - jInternalFrameSize.height) / 2;
        frame.setLocation(width, height);
        
        frame.setVisible(true);
    }
    
    public static void showInternalFrameAtCentre(JInternalFrame frame){
        dashboard.addFrame(frame);
        Info.clear();
        
        Dimension jDesktopPaneSize = dashboard.getJDesktopPaneSize();
        Dimension jInternalFrameSize = frame.getSize();
        int width = (jDesktopPaneSize.width - jInternalFrameSize.width) / 2;
        int height = (jDesktopPaneSize.height - jInternalFrameSize.height) / 2;
        frame.setLocation(width, height);
        
        frame.setVisible(true);
    }
}
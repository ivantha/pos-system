/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package ui.support;

import main.DashboardController;
import controller.ControllerFactory;
import ui.ColourPalatte;

/**
 *
 * @author Ivantha
 */
public class Info {
    private static final DashboardController dashboard = (DashboardController) ControllerFactory.getController(controller.Interface.DASHBOARD);
    
    public static void clear(){
        dashboard.changeInfo("", "");
    }
    
    public static void error(String title, String details){
        //JOptionPane.showMessageDialog(null, details, title, JOptionPane.ERROR_MESSAGE);
        dashboard.changeInfoColour(ColourPalatte.FONT_ORANGE);
        dashboard.changeInfo(title, details);
    }
    
    public static void error(String title, Exception ex){
        dashboard.changeInfoColour(ColourPalatte.FONT_ORANGE);
        dashboard.changeInfo(title, ex.getMessage());
    }
    
    public static void information(String title, String details){
        //JOptionPane.showMessageDialog(null, details, title, JOptionPane.INFORMATION_MESSAGE);
        dashboard.changeInfoColour(ColourPalatte.FONT_BLUE);
        dashboard.changeInfo(title, details);
    }
    
    public static void warning(String title, String details){
        //JOptionPane.showMessageDialog(null, details, title, JOptionPane.WARNING_MESSAGE);
        dashboard.changeInfoColour(ColourPalatte.FONT_ORANGE);
        dashboard.changeInfo(title, details);
    }
}

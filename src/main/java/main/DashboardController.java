/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package main;

import cache.EmployeeCache;
import controller.Controller;
import controller.ControllerFactory;
import controller.Interface;
import entity.Employee;
import goodreceive.NewGRNController;
import help.AboutController;
import history.*;
import inventory.ManageInventoryController;
import invoice.NewInvoiceController;
import management.customer.ManageCustomersController;
import management.employee.ManageEmployeesController;
import management.item.ManageItemsController;
import management.itemlist.ManageItemListsController;
import management.supplier.ManageSuppliersController;
import purchaseorder.NewPOController;
import purchasereturn.NewPRNController;
import salesreturn.NewSRNController;
import settings.AccountController;
import settings.SettingsController;
import ui.support.Info;

import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.awt.Frame.MAXIMIZED_BOTH;
import static main.support.Resources.ExportResource;

/**
 *
 * @author Ivantha
 */
public class DashboardController implements Controller {

    private final Dashboard view = new Dashboard();

    public DashboardController() {
        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                DashboardController.this.updateView();
            }
        });

        //Home tab>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        //Items
        view.addItemsButtonActionlistener((ActionEvent ae) -> {
            ManageItemsController controller = (ManageItemsController) ControllerFactory.getController(Interface.MANAGE_ITEMS);
            controller.showView();
        });

        //Item lists
        view.addItemListsButtonActionlistener((ActionEvent ae) -> {
            ManageItemListsController controller = (ManageItemListsController) ControllerFactory.getController(Interface.MANAGE_ITEM_LISTS);
            controller.showView();
        });

        //Suppliers
        view.addSuppliersButtonActionlistener((ActionEvent ae) -> {
            ManageSuppliersController controller = (ManageSuppliersController) ControllerFactory.getController(Interface.MANAGE_SUPPLIERS);
            controller.showView();
        });

        //Employees
        view.addEmployeesButtonActionlistener((ActionEvent ae) -> {
            ManageEmployeesController controller = (ManageEmployeesController) ControllerFactory.getController(Interface.MANAGE_EMPLOYEES);
            controller.showView();
        });

        //Customers
        view.addCustomersButtonActionlistener((ActionEvent ae) -> {
            ManageCustomersController controller = (ManageCustomersController) ControllerFactory.getController(Interface.MANAGE_CUSTOMERS);
            controller.showView();
        });

        //Purchase tab>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        //PO
        view.addPOButtonActionlistener((ActionEvent ae) -> {
            NewPOController controller = (NewPOController) ControllerFactory.getController(Interface.NEW_PO);
            controller.showView();
        });

        //GRN
        view.addGRNButtonActionlistener((ActionEvent ae) -> {
            NewGRNController controller = (NewGRNController) ControllerFactory.getController(Interface.NEW_GRN);
            controller.showView();
        });

        //PRN
        view.addPRNButtonActionlistener((ActionEvent ae) -> {
            NewPRNController controller = (NewPRNController) ControllerFactory.getController(Interface.NEW_PRN);
            controller.showView();
        });

        //PO history
        view.addPOHistoryButtonActionlistener((ActionEvent ae) -> {
            POHistoryController controller = (POHistoryController) ControllerFactory.getController(Interface.PO_HISTORY);
            controller.showView();
        });

        //GRN history
        view.addGRNHistoryButtonActionlistener((ActionEvent ae) -> {
            GRNHistoryController controller = (GRNHistoryController) ControllerFactory.getController(Interface.GRN_HISTORY);
            controller.showView();
        });

        //PRN history
        view.addPRNHistoryButtonActionlistener((ActionEvent ae) -> {
            PRNHistoryController controller = (PRNHistoryController) ControllerFactory.getController(Interface.PRN_HISTORY);
            controller.showView();
        });

        //Sales tab>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        //SO
        view.addSOButtonActionlistener((ActionEvent ae) -> {
            Info.error("Invalid function", "This feature is not yet implemented");
        });

        //Invoice
        view.addInvoiceButtonActionlistener((ActionEvent ae) -> {
            NewInvoiceController controller = (NewInvoiceController) ControllerFactory.getController(Interface.NEW_INVOICE);
            controller.showView();
        });

        //SRN
        view.addSRNButtonActionlistener((ActionEvent ae) -> {
            NewSRNController controller = (NewSRNController) ControllerFactory.getController(Interface.NEW_SRN);
            controller.showView();
        });

        //SO history
        view.addSOHistoryButtonActionlistener((ActionEvent ae) -> {
            Info.error("Invalid function", "This feature is not yet implemented");
        });

        //Invoice history
        view.addInvoiceHistoryButtonActionlistener((ActionEvent ae) -> {
            InvoiceHistoryController controller = (InvoiceHistoryController) ControllerFactory.getController(Interface.INVOICE_HISTORY);
            controller.showView();
        });

        //SRN history
        view.addSRNHistoryButtonActionlistener((ActionEvent ae) -> {
            SRNHistoryController controller = (SRNHistoryController) ControllerFactory.getController(Interface.SRN_HISTORY);
            controller.showView();
        });

        //Inventory tab>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        //Inventory
        view.addInventoryButtonActionListener((ActionEvent ae) -> {
            ManageInventoryController controller = (ManageInventoryController) ControllerFactory.getController(Interface.MANAGE_INVENTORY);
            controller.showView();
        });

        //User tab>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        //Account
        view.addAccountButtonActionlistener((ActionEvent ae) -> {
            AccountController controller = (AccountController) ControllerFactory.getController(Interface.ACCOUNT);
            controller.showView(EmployeeCache.getEmployee());
        });

        //Settings
        view.addSettingsButtonActionlistener((ActionEvent ae) -> {
            SettingsController controller = (SettingsController) ControllerFactory.getController(Interface.SETTINGS);
            controller.showView();
        });

        //Log out
        view.addLogOutButtonActionlistener((ActionEvent ae) -> {
            Login login = new Login();
            login.setVisible(true);
            view.mainJDP.removeAll();
            Info.clear();
            view.setVisible(false);
        });

        //Help tab>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        //User manual
        view.addUserManualButtonActionListener((ActionEvent ae) -> {
            try {
                String fullPath = ExportResource("/user_guide.chm");
                Runtime.getRuntime().exec("hh.exe " + fullPath);
            } catch (IOException ex) {
                Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //Version history
        view.addVersionHistoryButtonActionListener((ActionEvent ae) -> {
            try {
                String fullPath = ExportResource("/version_history.chm");
                Runtime.getRuntime().exec("hh.exe " + fullPath);
            } catch (IOException ex) {
                Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //About
        view.addAboutButtonActionListener((ActionEvent ae) -> {
            AboutController controller = (AboutController) ControllerFactory.getController(Interface.ABOUT);
            controller.showView();
        });
    }

    @Override
    public void showView() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void showView(Employee employee) {
        view.setTitle("POS System");
        view.setExtendedState(MAXIMIZED_BOTH);

        view.userIDValueLabel.setText("-  " + employee.getEmployeeID());
        view.userNameValueLabel.setText("-  " + employee.getName());
        view.roleValueLabel.setText("-  " + employee.getJob().getJobTitle());
        view.setVisible(true);
    }

    @Override
    public void updateView() {
    }

    @Override
    public void clearView() {
    }

    public void addFrame(JInternalFrame frame) {
        view.mainJDP.remove(frame);
        view.mainJDP.repaint();
        view.mainJDP.add(frame);
    }

    public Dimension getJDesktopPaneSize() {
        return view.mainJDP.getSize();
    }

    public void changeInfo(String title, String details) {
        view.infoTitleLabel.setText("<html>" + title + "</html>");
        view.infoDetailsLabel.setText("<html>" + details + "</html>");
    }

    public void changeInfoColour(Color colour) {
        view.infoTitleLabel.setForeground(colour);
        view.infoDetailsLabel.setForeground(colour);
    }
}

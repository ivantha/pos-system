/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package controller;

import management.customer.EditCustomerController;
import management.customer.ManageCustomersController;
import management.customer.NewCustomerController;
import main.DashboardController;
import management.employee.EditEmployeeController;
import management.employee.ManageEmployeesController;
import management.employee.NewEmployeeController;
import history.GRNHistoryController;
import goodreceive.GRNItemListController;
import goodreceive.NewGRNController;
import inventory.EditInventoryItemController;
import help.AboutController;
import inventory.ManageInventoryController;
import history.InvoiceHistoryController;
import invoice.NewInvoiceController;
import management.customer.CustomerHistoryController;
import management.employee.EmployeeHistoryController;
import management.item.EditItemController;
import management.itemlist.EditItemListController;
import management.itemlist.ManageItemListsController;
import management.itemlist.NewItemListController;
import management.item.ManageItemsController;
import management.item.NewItemController;
import java.util.HashMap;
import purchaseorder.NewPOController;
import history.POHistoryController;
import purchaseorder.PurchaseItemListController;
import purchasereturn.NewPRNController;
import history.PRNHistoryController;
import purchasereturn.PRNItemListController;
import salesreturn.NewSRNController;
import history.SRNHistoryController;
import salesreturn.SRNItemListController;
import management.supplier.EditSupplierController;
import management.supplier.ManageSuppliersController;
import management.supplier.NewSupplierController;
import management.supplier.SupplierHistoryController;
import settings.AccountController;
import settings.ChangePasswordController;
import settings.SettingsController;

/**
 *
 * @author Ivantha
 */
public class ControllerFactory {
    private static final HashMap<Interface, Controller> controllerMap = new HashMap<>();
    
    public static Controller getController(Interface i){
        Controller controller = controllerMap.get(i);
        
        if(controller == null){
            switch(i){
                case NEW_CUSTOMER:
                    controller = new NewCustomerController();
                    break;
                case EDIT_CUSTOMER:
                    controller = new EditCustomerController();
                    break;
                case MANAGE_CUSTOMERS:
                    controller = new ManageCustomersController();
                    break;
                case CUSTOMER_HISTORY:
                    controller = new CustomerHistoryController();
                    break;
                    
                case DASHBOARD:
                    controller = new DashboardController();
                    break;
                    
                case NEW_EMPLOYEE:
                    controller = new NewEmployeeController();
                    break;
                case EDIT_EMPLOYEE:
                    controller = new EditEmployeeController();
                    break;
                case MANAGE_EMPLOYEES:
                    controller = new ManageEmployeesController();
                    break;
                case EMPLOYEE_HISTORY:
                    controller = new EmployeeHistoryController();
                    break;
                    
                case NEW_GRN:
                    controller = new NewGRNController();
                    break;
                case GRN_ITEM_LIST:
                    controller = new GRNItemListController();
                    break;
                case GRN_HISTORY:
                    controller = new GRNHistoryController();
                    break;
                    
                case ABOUT:
                    controller = new AboutController();
                    break;
                    
                case NEW_INVOICE:
                    controller = new NewInvoiceController();
                    break;
                case INVOICE_HISTORY:
                    controller = new InvoiceHistoryController();
                    break;
                    
                case NEW_ITEM_LIST:
                    controller = new NewItemListController();
                    break;
                case EDIT_ITEM_LIST:
                    controller = new EditItemListController();
                    break;
                case MANAGE_ITEM_LISTS:
                    controller = new ManageItemListsController();
                    break;
                    
                case NEW_ITEM:
                    controller = new NewItemController();
                    break;
                case EDIT_ITEM:
                    controller = new EditItemController();
                    break;
                case MANAGE_ITEMS:
                    controller = new ManageItemsController();
                    break;
                    
                case NEW_PO:
                    controller = new NewPOController();
                    break;
                case PO_ITEM_LIST:
                    controller = new PurchaseItemListController();
                    break;
                case PO_HISTORY:
                    controller = new POHistoryController();
                    break;
                    
                case NEW_PRN:
                    controller = new NewPRNController();
                    break;
                case PRN_ITEM_LIST:
                    controller = new PRNItemListController();
                    break;
                case PRN_HISTORY:
                    controller = new PRNHistoryController();
                    break;
                    
                case NEW_SRN:
                    controller = new NewSRNController();
                    break;
                case SRN_ITEM_LIST:
                    controller = new SRNItemListController();
                    break;
                case SRN_HISTORY:
                    controller = new SRNHistoryController();
                    break;
                    
                case NEW_SUPPLIER:
                    controller = new NewSupplierController();
                    break;
                case EDIT_SUPPLIER:
                    controller = new EditSupplierController();
                    break;
                case MANAGE_SUPPLIERS:
                    controller = new ManageSuppliersController();
                    break;
                case SUPPLIER_HISTORY:
                    controller = new SupplierHistoryController();
                    break;
                    
                case MANAGE_INVENTORY:
                    controller = new ManageInventoryController();
                    break;
                case EDIT_INVENTORY_ITEM:
                    controller = new EditInventoryItemController();
                    break;
                    
                case ACCOUNT:
                    controller = new AccountController();
                    break;
                case SETTINGS:
                    controller = new SettingsController();
                    break;
                case CHANGE_PASSWORD:
                    controller = new ChangePasswordController();
                    break;
            }
            
            controllerMap.put(i, controller);
        }
        
        return controller;
    }
}

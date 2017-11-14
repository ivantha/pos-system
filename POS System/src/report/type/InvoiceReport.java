/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package report.type;

import report.Report;

/**
 *
 * @author Ivantha
 */
public class InvoiceReport extends Report{
    public void newInvoiceReport(String invoiceNo){
        map.clear();
        map.put("invoiceNo", invoiceNo);
        
        this.generateReport("invoice_report.jasper", map);
    }
}

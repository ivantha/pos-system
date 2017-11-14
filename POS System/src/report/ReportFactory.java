/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package report;

import java.util.HashMap;
import report.type.GoodReceiveReport;
import report.type.InvoiceReport;
import report.type.PurchaseOrderReport;
import report.type.PurchaseReturnReport;
import report.type.SalesReturnReport;

/**
 *
 * @author Ivantha
 */
public class ReportFactory {
    private static final HashMap<ReportForm, Report> reportMap = new HashMap<>();
    
    public static Report getReport(ReportForm r){
        Report report = reportMap.get(r);
        
        if(report == null){
            switch(r){
                case PURCHASE_ORDER:
                    report = new PurchaseOrderReport();
                    break;
                case GOOD_RECEIVE:
                    report = new GoodReceiveReport();
                    break;
                case PURCHASE_RETURN:
                    report = new PurchaseReturnReport();
                    break;
                case INVOICE:
                    report = new InvoiceReport();
                    break;
                case SALES_RETURN:
                    report = new SalesReturnReport();
                    break;
            }
            
            reportMap.put(r, report);
        }
        
        return report;
    }    
}

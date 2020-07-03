/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package report.type;

import report.Report;

/**
 *
 * @author Ivantha
 */
public class PurchaseOrderReport extends Report{
    public void newPOReport(String poNo){
        map.clear();
        map.put("poNo", poNo);
        
        this.generateReport("po_report.jasper", map);
    }
}

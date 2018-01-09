/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package report.type;

import report.Report;

/**
 *
 * @author Ivantha
 */
public class PurchaseReturnReport extends Report{
    public void newPRNReport(String prnNo){
        map.clear();
        map.put("prnNo", prnNo);
        
        this.generateReport("prn_report.jasper", map);
    }
}

/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package report.type;

import report.Report;

/**
 *
 * @author Ivantha
 */
public class SalesReturnReport extends Report{
    public void newSRNReport(String srnNo){
        map.clear();
        map.put("srnNo", srnNo);
        
        this.generateReport("srn_report.jasper", map);
    }
}

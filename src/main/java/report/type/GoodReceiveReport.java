/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package report.type;

import report.Report;

/**
 *
 * @author Ivantha
 */
public class GoodReceiveReport extends Report{
    public void newGRNReport(String grnNo){
        map.clear();
        map.put("grnNo", grnNo);
        
        this.generateReport("grn_report.jasper", map);
    }
}

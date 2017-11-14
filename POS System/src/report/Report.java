/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package report;

import database.Connect;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static main.support.Resources.ExportResource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.type.OrientationEnum;
import net.sf.jasperreports.engine.type.WhenNoDataTypeEnum;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Ivantha
 */
public abstract class Report {
    //public String reportDirectory = System.getProperty("user.dir") + "\\resources\\";
    
    public final Map<String, String> map = new LinkedHashMap<>();
   
    public void generateReport(String reportName, Map params) {
        try {
            //Copy report outside of jar folder
            String reportPath = ExportResource("/resources/" + reportName);
            
            //JasperReport jr = JasperCompileManager.compileReport(reportDirectory + reportName);
            JasperReport jr = JasperCompileManager.compileReport(reportPath);

            jr.setWhenNoDataType(WhenNoDataTypeEnum.NO_PAGES);

            JasperPrint jp = JasperFillManager.fillReport(jr, params, new Connect().Conn());
            jp.setOrientation(OrientationEnum.PORTRAIT);
            List<JRPrintPage> p = jp.getPages();

            if (!p.isEmpty()) {
                JasperViewer.viewReport(jp, false);

            } else {
                JOptionPane.showMessageDialog(null, "NO PAGES !!!!");
            }

        } catch (JRException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

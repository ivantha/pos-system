/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package database.sql;

import database.Connect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ivantha
 */
public abstract class SQL {
    protected Connect c = new Connect();
    protected ResultSet rs;
    protected String query;
    protected String result;
    
    public String getLastValue(String tableName, String columnName){
        query = "SELECT " + columnName + " FROM " + tableName + " ORDER BY " + columnName + " DESC LIMIT 1";
        rs = c.getQuery(query);
        
        try {
            while(rs.next()){
                result = rs.getString(columnName);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
}

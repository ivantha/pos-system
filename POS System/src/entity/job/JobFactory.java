/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package entity.job;

import exception.JobRoleNotFoundException;
import entity.job.type.AssistantManager;
import entity.job.type.Bagger;
import entity.job.type.Cashier;
import entity.job.type.Cleaner;
import entity.job.type.DeliveryDriver;
import entity.job.type.Manager;
import entity.job.type.StockKeeper;

/**
 *
 * @author Ivantha
 */
public class JobFactory {
    public static Job getJobRole(String jobRoleTitle) throws JobRoleNotFoundException{
        switch(jobRoleTitle){
            case "Manager": 
                return new Manager();
            case "Assistant Manager":
                return new AssistantManager();
            case "Stock Keeper":
                return new StockKeeper();
            case "Cashier":
                return new Cashier();
            case "Bagger":
                return new Bagger();
            case "Delivery Driver":
                return new DeliveryDriver();
            case "Cleaner":
                return new Cleaner(); 
            default:
                throw new JobRoleNotFoundException();
        }     
    }
    
    public static Job getJobRole(int jobRoleID) throws JobRoleNotFoundException{
        switch(jobRoleID){
            case 1: 
                return new Manager();
            case 2:
                return new AssistantManager();
            case 3:
                return new StockKeeper();
            case 4:
                return new Cashier();
            case 5:
                return new Bagger();
            case 6:
                return new DeliveryDriver();
            case 7:
                return new Cleaner(); 
            default:
                throw new JobRoleNotFoundException();
        }     
    }
}

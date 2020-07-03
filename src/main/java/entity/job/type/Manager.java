/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package entity.job.type;

import entity.job.Job;

/**
 *
 * @author IvanthaS
 */
public class Manager extends Job{
    @Override
    public int getJobID() {
        return 1;
    }
    
    @Override
    public String getJobTitle() {
        return "Manager";
    }
}

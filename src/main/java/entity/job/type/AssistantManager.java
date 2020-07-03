/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package entity.job.type;

import entity.job.Job;

/**
 *
 * @author Ivantha
 */
public class AssistantManager extends Job{
    @Override
    public int getJobID() {
        return 2;
    }
    
    @Override
    public String getJobTitle() {
        return "Assistant Manager";
    }
}

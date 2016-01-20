package com.webapp.utils;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.webapp.actions.AbstractServletHandler;


public class QuartzJob extends AbstractServletHandler implements Job {
	

	private static final long serialVersionUID = 1L;

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
	getCustomerService().deleteUnverifiedProfiles();
	
		
	}

}

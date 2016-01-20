package com.webapp.utils;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.services.CustomerService;
import com.webapp.services.Impl.CustomerServiceImpl;

public class QuartzJob extends AbstractServletHandler implements Job {
	
//	CustomerService service = new CustomerServiceImpl();

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
	getCustomerService().deleteUnverifiedProfiles();
	System.out.println("deleted");
		
	}

}

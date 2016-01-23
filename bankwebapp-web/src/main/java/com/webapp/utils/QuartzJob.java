package com.webapp.utils;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.dao.impl.CustomerDaoImpl;
import com.webapp.services.CustomerService;
import com.webapp.services.Impl.CustomerServiceImpl;


public class QuartzJob extends AbstractServletHandler implements Job {
	

	private static final long serialVersionUID = 1L;
	
	CustomerService customerService = new CustomerServiceImpl(new CustomerDaoImpl());

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		customerService.deleteUnverifiedProfiles();
	
		
	}

}

package com.sunbeam.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener {
	
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext ctx = sce.getServletContext();
		System.out.println("ElectrionServlets Application started.");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ElectrionServlets Application stopped.");
	}

}

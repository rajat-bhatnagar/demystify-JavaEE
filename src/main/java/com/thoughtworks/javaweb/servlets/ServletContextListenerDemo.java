package com.thoughtworks.javaweb.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class ServletListenerDemo
 *
 */
public class ServletContextListenerDemo implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ServletContextListenerDemo() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
        System.out.println("\n ***************** init ************************* \n");
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	System.out.println("\n ***************** destroyed ************************* \n");
    }
	
}

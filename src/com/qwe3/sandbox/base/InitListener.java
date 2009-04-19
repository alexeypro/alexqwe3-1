package com.qwe3.sandbox.base;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import ognl.OgnlRuntime;

public class InitListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public InitListener()  {
    }

    public void contextInitialized(ServletContextEvent sce)  {
        OgnlRuntime.setSecurityManager(null);
    }

    public void contextDestroyed(ServletContextEvent arg0) {
    }

    public void sessionCreated(HttpSessionEvent arg0) {
    }

    public void sessionDestroyed(HttpSessionEvent arg0) {
    }

    public void attributeAdded(HttpSessionBindingEvent arg0) {        
    }

    public void attributeRemoved(HttpSessionBindingEvent arg0) {
    }

    public void attributeReplaced(HttpSessionBindingEvent arg0) {
    }
}

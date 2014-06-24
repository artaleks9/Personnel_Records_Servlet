package com.hometask.webinterface;

import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestListener;
import javax.servlet.ServletRequestAttributeListener;


public class ListenerPerson implements ServletContextListener,
        ServletRequestAttributeListener,ServletRequestListener {

    ServletContext contx;
    String name;

    public ListenerPerson() {
    }

    public void requestDestroyed(ServletRequestEvent sre) {
        contx.log("A request has been destroyed at: " + new Date());
    }

    public void contextInitialized(ServletContextEvent sce) {
        contx = sce.getServletContext();
        contx.log("Context has been initialized at " + new Date());
    }

    public void attributeAdded(ServletRequestAttributeEvent event) {
        name = event.getName();
        contx.log("An attribute with name: " + name
                + " has been added to the servlet at: " + new Date());
    }
    public void attributeReplaced(ServletRequestAttributeEvent event) {
        contx.log("Attribute with name: " + name
                + " has been replaced servlet at: " + new Date());
    }

    public void attributeRemoved(ServletRequestAttributeEvent event) {
        contx.log("Attribute with name: " + name
                + " has been removed from the servlet at: " + new Date());
    }

    public void contextDestroyed(ServletContextEvent sce) {
        contx.log("Context has been destroyed at " + new Date());
    }

    public void requestInitialized(ServletRequestEvent sre) {
        contx.log("A request has been initialized at: " + new Date());
    }
}








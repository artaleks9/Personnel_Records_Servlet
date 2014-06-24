package com.hometask.webinterface;
/**
 * Checking the values that the user has entered
 in the form of adding a new employee.
 */

import javax.servlet.*;
import java.util.Enumeration;
import java.io.IOException;

public class CheckFilter implements Filter {

    private FilterConfig config;

    public CheckFilter(){

    }

    public void init(FilterConfig filterConfig) throws ServletException {

        config = filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        Enumeration params = request.getParameterNames();
        boolean rejected = false;
        while (params.hasMoreElements()){
            if(isEmpty(request.getParameter((String)params.nextElement()))){
                rejected = true;
                reject(request,response);
            }
        }
        if(!rejected)
        chain.doFilter(request, response);
    }

    private boolean isEmpty(String param) {
        if(param == null || param.length()<1){
            return true;
        }
        return false;
    }

    private void reject(ServletRequest request,ServletResponse response)
        throws IOException,ServletException{

        request.setAttribute("errorMsg","Please make sure to provide a " +
                "valid value for all of the text fields");

        Enumeration params = request.getParameterNames();
        String paramN;
        while (params.hasMoreElements()){
            paramN = (String)params.nextElement();
            request.setAttribute(paramN,request.getParameter(paramN));
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    public void destroy() {
    }

}

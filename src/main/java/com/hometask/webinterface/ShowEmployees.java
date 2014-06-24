package com.hometask.webinterface;

import com.hometask.precords.Company;
import com.hometask.precords.InvalidArgumentException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowEmployees extends HttpServlet {

    private Company instanceCompany;
    List listEmployees = null;

    public void init() throws ServletException {
        instanceCompany = Company.getInstance();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       super.doPost(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(listEmployees == null){
            try {
                listEmployees = instanceCompany.createListEmpl();
            } catch (InvalidArgumentException e) {
                e.printStackTrace();
            }
        }
        assert listEmployees != null;
        response.setContentType("text/html");
        request.setAttribute("count", listEmployees.size());
        request.setAttribute("employees",listEmployees);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}

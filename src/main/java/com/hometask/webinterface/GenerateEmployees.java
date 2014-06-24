package com.hometask.webinterface;

import com.hometask.precords.Company;
import com.hometask.precords.InvalidArgumentException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GenerateEmployees extends HttpServlet {

    private Company instanceCompany;
    List listEmployees;

    public void init() throws ServletException {
        instanceCompany = Company.getInstance();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String count = request.getParameter("count");
        if(count != null) {
            try {
                listEmployees = instanceCompany.createListEmpl(Integer.parseInt(count));
            } catch (InvalidArgumentException e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("/Company/showemployees");
    }
}

package com.hometask.webinterface;

import com.hometask.precords.Company;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteEmployee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Company instanceCompany = Company.getInstance();
        String surName = request.getParameter("employeename");
        instanceCompany.removeEmployee(surName);
        response.sendRedirect("/Company/showemployees");
    }
}

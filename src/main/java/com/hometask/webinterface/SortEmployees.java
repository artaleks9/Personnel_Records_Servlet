package com.hometask.webinterface;

import com.hometask.precords.Company;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SortEmployees extends HttpServlet {

    private Company instanceCompany;

    public void init() throws ServletException {
        instanceCompany = Company.getInstance();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sort = request.getParameter("sort");

        switch (sort) {
            case "idn":
                try {
                    instanceCompany.sortId();
                } catch (IllegalAccessException | InstantiationException e) {
                    e.printStackTrace();
                }
                break;
            case "name":
                try {
                    instanceCompany.sortSurname();
                } catch (IllegalAccessException | InstantiationException e) {
                    e.printStackTrace();
                }
                break;
            case "date":
                try {
                    instanceCompany.sortDate();
                } catch (IllegalAccessException | InstantiationException e) {
                    e.printStackTrace();
                }
                break;
            case "salary":
                try {
                    instanceCompany.sortSalary();
                } catch (IllegalAccessException | InstantiationException e) {
                    e.printStackTrace();
                }
                break;
        }
        response.sendRedirect("/Company/showemployees");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("/Company/showemployees");
    }
}

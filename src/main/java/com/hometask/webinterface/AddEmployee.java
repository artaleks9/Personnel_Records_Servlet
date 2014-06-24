package com.hometask.webinterface;

import com.hometask.precords.Company;
import com.hometask.precords.Initializer;
import com.hometask.precords.InvalidArgumentException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddEmployee extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Company instanceCompany = Company.getInstance();
        String idn = request.getParameter("idn");
        String surname = request.getParameter("surname");
        String date = request.getParameter("date");
        String salary = request.getParameter("salary");
        String type = request.getParameter("type");

        if(type.equals("fixed")){
            try {
                instanceCompany.getListEmployees().add(Initializer.createEmpFixed(idn, surname, date,
                        Double.parseDouble(salary)));
            }catch(InvalidArgumentException e){
                e.printStackTrace();
            }
        }else{
            try {
                instanceCompany.getListEmployees().add(Initializer.createEmpHourly(idn, surname, date,
                        Double.parseDouble(salary)));
            }catch(InvalidArgumentException e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("/Company/showemployees");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("/Company/showemployees");
    }
}

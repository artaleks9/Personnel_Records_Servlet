package com.hometask.precords;

public class EmployeeFixedSalary extends Employee{

    private double fixedPayment;

    public double getFixedPayment() {
        return fixedPayment;
    }

    public void setFixedPayment(double fixedPayment) {
        this.fixedPayment = fixedPayment;
    }

    public double getAvrSalary(){
        return fixedPayment;
    }

    public String toString(){
        return "\nEmployee with fixed salary\n"+getEmployeeNumber()
         +"\n"+getSurname()+"\n"+getDateOfBirth()+"\n"+getFixedPayment()
         +"\n"+getAvrSalary()+"\n";
    }
}

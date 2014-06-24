package com.hometask.precords;

import java.io.Serializable;

public abstract class Employee implements Serializable {

    private String employeeNumber;
    private String surname;
    private String dateOfBirth;

    public abstract double getAvrSalary();
    public abstract String toString();

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setSurname(String surname) {

        this.surname = surname;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public String getSurname() {
        return surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

}

package com.hometask.precords;

public class EmployeeHourlyWages extends Employee{

    private double hourlyRate;

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getAvrSalary(){
        return 20.8*8*hourlyRate;
    }

    public String toString(){
        return "\nEmployee with hourly wages\n"+getEmployeeNumber()
                +"\n"+getSurname()+"\n"+getDateOfBirth()+"\n"+getHourlyRate()
                +"\n"+getAvrSalary()+"\n";
    }
}

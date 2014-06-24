package com.hometask.precords;

import java.util.Comparator;

public class SortSalary implements Comparator <Employee> {

    public int compare(Employee e1, Employee e2) {
        return (int) (e1.getAvrSalary()-e2.getAvrSalary());
    }
}

package com.hometask.precords;

import java.util.Comparator;

public class SortId  implements Comparator <Employee> {

    public int compare(Employee e1, Employee e2) {
        return e1.getEmployeeNumber().compareTo(e2.getEmployeeNumber());
    }
}

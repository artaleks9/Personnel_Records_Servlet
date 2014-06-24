package com.hometask.precords;

import java.util.Comparator;

public class SortSurname implements Comparator <Employee> {

    public int compare(Employee e1, Employee e2) {
        return e1.getSurname().compareTo(e2.getSurname());
    }
}

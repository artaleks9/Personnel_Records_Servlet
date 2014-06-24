package com.hometask.precords;

import java.util.Comparator;

public class SortDate implements Comparator <Employee>{

    public int compare(Employee e1, Employee e2) {
        return e1.getDateOfBirth().compareTo(e2.getDateOfBirth());
    }
}

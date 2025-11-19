package com.model;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final List<Child> children;

    public Person() {
        this.children = new ArrayList<>();
    }

    public List<Child> getChildren() {
        return children;
    }
}



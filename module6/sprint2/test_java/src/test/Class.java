package test;

import java.util.*;

public class Class {
    String name;

    static String a = "hello";
    int b = 18;

    static void showNumber() {
        System.out.println(a);
    }

    public Class(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

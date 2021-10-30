package com.creospan.rpi.setexample;

public class PrimSet {

    private String myContainer = "";

    public void add(String someString) {
        myContainer = someString;
    }

    public boolean contains(String someString) {
        return myContainer.equals(someString);
    }
}

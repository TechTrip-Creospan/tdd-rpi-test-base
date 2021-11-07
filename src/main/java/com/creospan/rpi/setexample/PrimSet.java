package com.creospan.rpi.setexample;

public class PrimSet {

    private String myContainer = "";

    public void add(String someString) {
        if (someString == null) {
            throw new NullPointerException("PrimSet does not allow nulls");
        }
        myContainer = someString;
    }

    public boolean contains(String someString) {
        return myContainer.equals(someString);
    }
}

package com.creospan.rpi.setexample;

import java.util.Arrays;

public class PrimSet {

    private String[] mySetContainer = new String[0];

    public void add(String someString) {
        if (someString == null) {
            throw new NullPointerException("PrimSet does not allow nulls");
        }

        if (!this.contains(someString)) {
            mySetContainer = Arrays.copyOf(mySetContainer, mySetContainer.length + 1);
            mySetContainer[mySetContainer.length - 1] = someString;
        }
    }

    public boolean contains(String someString) {
        return Arrays.stream(mySetContainer).anyMatch(valueInSet -> someString.equals(valueInSet));
    }

    public int size() {
        return mySetContainer.length;
    }

    public boolean isEmpty() {
        return false;
    }
}

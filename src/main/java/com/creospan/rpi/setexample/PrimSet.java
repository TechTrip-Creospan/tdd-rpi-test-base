package com.creospan.rpi.setexample;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

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
        return (mySetContainer.length == 0);
    }

    public void clear() {
        mySetContainer = new String[0];
    }

    public void remove(String someString) {
        if (!this.contains(someString)) {
            return;
        }

        String[] newContainer = new String[mySetContainer.length - 1];

        AtomicInteger index = new AtomicInteger(0);

        Arrays.stream(mySetContainer).forEach(valueInSet -> {
            // Don't put someString on the left, protect from nulls
            if (!valueInSet.equals(someString)) {
                newContainer[index.getAndIncrement()] = valueInSet;
            }
        });

        mySetContainer = newContainer;
    }
}

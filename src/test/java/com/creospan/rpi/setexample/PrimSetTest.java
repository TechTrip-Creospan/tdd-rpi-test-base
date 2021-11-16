package com.creospan.rpi.setexample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PrimSetTest {

    PrimSet primSet;

    @BeforeEach
    void setUp() {
        primSet = new PrimSet();
    }

    @Test
    void setCanHoldAnObject() {
        String someString = "someString";
        primSet.add(someString);
        assertThat(primSet.contains(someString)).isTrue();
    }

    @Test
    void setCannotContainNulls() {
        NullPointerException nullPointerException = assertThrows(NullPointerException.class, () -> {
            primSet.add(null);
        });
        assertThat(nullPointerException.getMessage()).isEqualTo("PrimSet does not allow nulls");
    }

    @Test
    void setCanHoldManyObjects() {
        String[] someStrings = {"String1", "String2", "String3"};

        Arrays.stream(someStrings).forEach(s -> {
            primSet.add(s);
        });

        assertThat(primSet.size()).isEqualTo(someStrings.length);

        Arrays.stream(someStrings).forEach(s -> {
            assertThat(primSet.contains(s));
        });
    }

    @Test
    void setCannotHoldDuplicates() {
        String someString = "someString";

        primSet.add(someString);
        primSet.add(someString);

        assertThat(primSet.size()).isEqualTo(1);
        assertThat(primSet.contains(someString));
    }

    @Test
    void setIsEmpty() {
        assertThat(primSet.isEmpty()).isTrue();
    }

    @Test
    void setCanBeCleared() {
        primSet.add("some String");
        primSet.add("another String");
        primSet.clear();
        assertThat(primSet.size()).isEqualTo(0);
        assertThat(primSet.isEmpty()).isTrue();
    }

    @Test
    void objectsCanBeRemovedFromSet() {
    }
}
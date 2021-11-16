package com.creospan.rpi.setexample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PrimSetTest {
    @BeforeEach
    void setUp() {

    }

    @Test
    void setCanHoldAnObject() {
        PrimSet primSet = new PrimSet();
        String someString = "someString";
        primSet.add(someString);
        assertThat(primSet.contains(someString)).isTrue();
    }

    @Test
    void setCannotContainNulls() {
        PrimSet primSet = new PrimSet();
        NullPointerException nullPointerException = assertThrows(NullPointerException.class, () -> {
            primSet.add(null);
        });
        assertThat(nullPointerException.getMessage()).isEqualTo("PrimSet does not allow nulls");
    }

    @Test
    void setCanHoldManyObjects() {
        PrimSet primSet = new PrimSet();
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
        PrimSet primSet = new PrimSet();
        String someString = "someString";

        primSet.add(someString);
        primSet.add(someString);

        assertThat(primSet.size()).isEqualTo(1);
        assertThat(primSet.contains(someString));
    }

    @Test
    void setIsEmpty() {
        PrimSet primSet = new PrimSet();
        assertThat(primSet.isEmpty()).isTrue();
    }

    @Test
    void setCanBeCleared() {
    }

    @Test
    void objectsCanBeRemovedFromSet() {
    }
}
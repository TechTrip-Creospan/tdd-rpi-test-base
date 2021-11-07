package com.creospan.rpi.setexample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    }

    @Test
    void setCannotHoldDuplicates() {
    }

    @Test
    void setCanHoldManyObjects() {
    }

    @Test
    void setIsEmpty() {
    }

    @Test
    void setCanBeCleared() {
    }

    @Test
    void objectsCanBeRemovedFromSet() {
    }
}
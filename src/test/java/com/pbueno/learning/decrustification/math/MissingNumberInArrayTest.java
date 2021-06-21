package com.pbueno.learning.decrustification.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MissingNumberInArrayTest {
    @Test
    void findMissingTest(){
        MissingNumberInArray test = new MissingNumberInArray();

        int[] array = {1,2,3,5};
        int result = test.findMissing(array, 5);
        assertEquals(4, result);
        array = new int[]{1};
        result = test.findMissing(array, 2);
        assertEquals(2, result);

        array = new int[]{5,2,4,1,7,8,6,9,3};
        result = test.findMissing(array, 10);
        assertEquals(10, result);
    }
}
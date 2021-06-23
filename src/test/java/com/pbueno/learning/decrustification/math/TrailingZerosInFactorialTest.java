package com.pbueno.learning.decrustification.math;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TrailingZerosInFactorialTest {

    @Test
    void trailingOfFactorialTest(){
        TrailingZerosInFactorial test = new TrailingZerosInFactorial();
        int result = test.trailingOfFactorialBigNumbers(5);
        assertEquals(1, result);
        result = test.trailingOfFactorialBigNumbers(4);
        assertEquals(0, result);

    }

    @Test
    void bigNumbersTest(){
        TrailingZerosInFactorial test = new TrailingZerosInFactorial();
        // warmup
        long start = System.currentTimeMillis();
        test.trailingOfFactorialBigNumbers(1000);
//        assertTrue(System.currentTimeMillis() - start < 10000);
        System.out.println(System.currentTimeMillis() - start + " ms");

    }

    @Test
    void onlyZerosTest(){
        TrailingZerosInFactorial test = new TrailingZerosInFactorial();
        int result = test.onlyZeros(5);
        assertEquals(1, result);
        result = test.onlyZeros(4);
        assertEquals(0, result);
        result = test.onlyZeros(6);
        assertEquals(1, result);
        result = test.onlyZeros(20);
        assertEquals(4, result);
        result = test.onlyZeros(384);
        assertEquals(94, result);
    }
}
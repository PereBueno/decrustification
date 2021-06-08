package com.pbueno.learning.decrustification.dates;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    void addDate() {
        Date testDate = new Date(2021, 6, 7);
        Date result = testDate.addDate(5);
        Assert.assertEquals(12, result.day);    // Happy path, no month change

        result = testDate.addDate(30);
        Assert.assertEquals(7, result.day);
        Assert.assertEquals(7, result.month);   // month change, simple

        testDate = new Date(2021, 12, 27);
        result = testDate.addDate(5);
        Assert.assertEquals(1, result.day);    // Year change, simple
        Assert.assertEquals(1, result.month);
        Assert.assertEquals(2022, result.year);

        testDate = new Date(2021, 6, 7);
        result = testDate.addDate(62);  // should match +30 + 31 + 1 = 8th august
        Assert.assertEquals(8, result.day);    // Adding multiple months
        Assert.assertEquals(8, result.month);

        testDate = new Date(2021, 10, 25);
        result = testDate.addDate(92);  // should match +31 + 30 + 31 = 25th Jan 2022
        Assert.assertEquals(25, result.day);    // Adding multiple months
        Assert.assertEquals(1, result.month);
        Assert.assertEquals(2022, result.year);
    }
}
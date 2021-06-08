package com.pbueno.learning.decrustification.roman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumberTest {

    @Test
    void toInteger() {
        RomanNumber roman = new RomanNumber("MCMXC");
        Assertions.assertEquals((Integer)1990, roman.toInteger());
        roman = new RomanNumber("MCMLXXVII");
        Assertions.assertEquals((Integer)1977, roman.toInteger());
        roman = new RomanNumber("CDLXXXIV");
        Assertions.assertEquals((Integer)484, roman.toInteger());
        final RomanNumber failingRoman = new RomanNumber("IC");
        Assertions.assertThrows(NumberFormatException.class, () -> failingRoman.toInteger());
    }

    @Test
    void validateTest(){
        RomanNumber roman = new RomanNumber("MCMXC"); // 1990 is valid
        Assertions.assertTrue(roman.validate());
        roman = new RomanNumber("MCCMXC"); // 2 Cs, not valid
        Assertions.assertFalse(roman.validate());
        roman = new RomanNumber("MGCMXC"); // G is not valid
        Assertions.assertFalse(roman.validate());
        roman = new RomanNumber("MCMLXC"); // Not valid, L not allowed there
        Assertions.assertFalse(roman.validate());
        roman = new RomanNumber("MCMDXC"); // Not valid, D not allowed there
        Assertions.assertFalse(roman.validate());
        roman = new RomanNumber("MCMXIIII"); // Not valid, 4 consecutive Is
        Assertions.assertFalse(roman.validate());
        roman = new RomanNumber("MCMXXXX"); // Not valid, 4 consecutive Xs
        Assertions.assertFalse(roman.validate());
        roman = new RomanNumber("MCCCC"); // Not valid, 4 consecutive Cs
        Assertions.assertFalse(roman.validate());
        roman = new RomanNumber("MMDD"); // Not valid, 2 consecutive Ds
        Assertions.assertFalse(roman.validate());
        roman = new RomanNumber("MMLL"); // Not valid, 2 consecutive Ls
        Assertions.assertFalse(roman.validate());
        roman = new RomanNumber("MMCCD"); // Not valid, CCD should be CCC
        Assertions.assertFalse(roman.validate());
        roman = new RomanNumber("MCMLXXVII"); // valid, 1977
        Assertions.assertTrue(roman.validate());
    }
}
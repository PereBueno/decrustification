package com.pbueno.learning.decrustification.roman;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman number, create a method that writes its decimal equivalent
 */

public class RomanNumber {
    String roman;
    Map<Character, Integer> values = new HashMap<>();

    public RomanNumber(String value){
        this.roman = value;
        initializeValues();
    }

    private void initializeValues(){
        values.put('M', 1000);
        values.put('D', 500);
        values.put('C', 100);
        values.put('L', 50);
        values.put('X', 10);
        values.put('V', 5);
        values.put('I', 1);
    }

    public boolean validate(){
        return this.roman.matches("M*(CD|CM|D?C{0,3})(XL|XC|L?X{0,3})(IX|IV|V?I{0,3})");
    }

    public Integer toInteger(){
        if (!validate())
            throw new NumberFormatException(String.format("Invalid roman number: {%s}", this.roman));
        char[] original = this.roman.toCharArray();
        Integer result = 0;
        for (int i = 0; i < original.length; i++){
            if (i+1 < original.length && values.get(original[i]) < values.get(original[i+1])){
                result += values.get(original[i+1]) - values.get(original[i]);
                i++;
            }else
                result+=values.get(original[i]);
        }
        return result;
    }
}

package com.pbueno.learning.decrustification.math;


import java.math.BigDecimal;

/**
 * for any integer N find the number of trailing 0s in N!
 * Ex:  N=5 --> N! = 120 --> 1
 *      N=4 --> N! = 24 --> 0
 * Calculation must complete in O(log(n))
 * 1 <= N <= 10^9
 */
public class TrailingZerosInFactorial {

    /* Classic recursive factorial fails for big numbers, stackOverflow due to too many recursive calls
        Implementing a non recursive solution
     */
    public BigDecimal recursiveFactorial (int input){
        if (input == 1)
            return new BigDecimal(1);
        else
            return new BigDecimal(input).multiply(recursiveFactorial(input-1));
    }

    /* Iterative solution, ends, but time grow exponentially
     */
    public BigDecimal factorial (int input){
        BigDecimal result = BigDecimal.ONE;
        for (int i = 2; i <= input; i++) {
            result = result.multiply(new BigDecimal(i));
        }
        return result;
    }

    /* Paper-like multiplication, divide and carry into an array,
     * returns the new size, as number will be stored in an array of ints
     */
    public int multiply(int current, int[] res, int resSize){
        int carry = 0;
        for (int i = 0; i < resSize; i++){  // calculate digit for current position and advance
            int prod = res[i] * current + carry;
            res[i] = prod % 10;
            carry = prod / 10;
        }
        while(carry != 0){  // While there's carry increase positions
            res[resSize] = carry % 10;
            carry = carry / 10;
            resSize++;
        }
        System.out.println(resSize);
        return resSize;
    }

    /* Again, recursive here is too slow
     */
    private int trailingZeros (BigDecimal number){
        if (number.remainder(BigDecimal.valueOf(10)).intValue() != 0)
            return 0;
        else return 1 + trailingZeros(number.divide(BigDecimal.valueOf(10)));
    }

    public int trailingOfFactorial(int input){
        System.out.println("***************\nRecursive\n");
        long start = System.currentTimeMillis();
        BigDecimal fact = factorial(input);
        System.out.println("fact\t" + (System.currentTimeMillis() - start + " ms"));
        start = System.currentTimeMillis();
        int res = trailingZeros(fact);
        System.out.println("zeros\t" + (System.currentTimeMillis() - start + " ms"));
        return res;
    }

    public int trailingOfFactorialBigNumbers(int input){

        long start = System.currentTimeMillis();
        int[] res = new int[5000];
        res[0]=1;
        int resSize = 1;
        for (int i = 2; i <= input; i++)
            resSize = multiply(i, res, resSize);

        // Here we have an array with the number, reversed, so in order to build a number we could build a string + convert
//        StringBuilder sb = new StringBuilder();
//        for (int i = resSize - 1; i >= 0; i--)
//            sb.append(res[i]);
        start = System.currentTimeMillis();
        int result =  0;
        while(res[result] % 10 == 0){
            result++;
        }
        return result;
    }

    /*
     * Still too slow, let's ignore the factorial and simply use the number of zeros, once we have a 0 it will
     * increase at a given rate.
     * Rate is simple, zeros will only be added if multiplying by 5 or multiples (2*5...)
     */
    public int onlyZeros(int input){
        int zeros = 0;
        while (input / 5 >= 1) {
            zeros+=(input/5);
            input /= 5;
        }
        return zeros;
    }



}

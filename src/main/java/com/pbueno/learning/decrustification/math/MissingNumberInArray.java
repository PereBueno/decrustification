package com.pbueno.learning.decrustification.math;

/**
 * Given an unordered array of int and the size, find the missing element
 * Solution must end in O(n)
 * [1,2,4,5] ---> 3
 * [3,4,1,2] ---> 5
 */
public class MissingNumberInArray {

    public int findMissing(int[] array, int size) {
        int sum = factSum(size);
        for (int i = 0; i < size - 1; i++)
            sum -= array[i];
        return sum;
    }

    public int factSum(int size) {
        if (size == 1)
            return 1;
        else
            return size + factSum(size - 1);
    }
}

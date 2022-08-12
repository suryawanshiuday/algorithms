package com.udays.algorithms.sorting;

import org.junit.Assert;

public class InsertionSort {

    public static void main(String... args){
        int[] nums = new int[]{6,2,8,4,3,10,7,5};
        insertionSort(nums);
        int[] expected = new int[]{2,3,4,5,6,7,8,10};
        printArray(nums);
        Assert.assertArrayEquals(expected, nums);
    }

    private static void insertionSort(int[] nums){
        //iterate from 1 to N to compare i and i-1
        for(int i=1; i<nums.length; i++){
            //iterate from i to 0 to find correct position of ith element
            for(int j=i; j>0; j--){
                //keep swapping until ith element reaches at correct sorted position
                if(nums[j]<nums[j-1]){
                    int tmp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = tmp;
                } else{
                    break;
                }
            }
        }
    }

    private static void printArray(int[] nums){
        for(int i: nums)
            System.out.print(i+",");
    }

}

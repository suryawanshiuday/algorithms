package com.udays.algorithms.sorting;

import org.junit.Assert;

public class SelectionSort {

    public static void main(String... args){
        int[] nums = new int[]{6,2,8,4,3,10,7,5};
        selectionSort(nums);
        int[] expected = new int[]{2,3,4,5,6,7,8,10};
        printArray(nums);
        Assert.assertArrayEquals(expected, nums);
    }

    private static void selectionSort(int[] nums){
        //outer loop to go over n numbers
        for(int i=0; i< nums.length; i++){
            //iterate on all numbers and find smallest
            //smallest number will be swapped at ith position
            //and then i++
            //that means keep setting smallest number for every ith position looking at i+1 to N
            int smaller = i;
            for(int j=i+1; j<nums.length; j++){
                if(nums[j]<nums[smaller])
                    smaller=j;
            }
            int tmp = nums[smaller];
            nums[smaller] = nums[i];
            nums[i] = tmp;
        }
    }

    private static void printArray(int[] nums){
        for(int i: nums)
            System.out.print(i+",");
    }

}

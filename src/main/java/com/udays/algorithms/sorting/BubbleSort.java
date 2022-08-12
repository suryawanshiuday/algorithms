package com.udays.algorithms.sorting;

import org.junit.Assert;

public class BubbleSort {

    public static void main(String... args){
        int[] nums = new int[]{6,2,8,4,3,10,7,5};
        bubbleSort(nums);
        int[] expected = new int[]{2,3,4,5,6,7,8,10};
        printArray(nums);
        Assert.assertArrayEquals(expected, nums);
    }

    private static void bubbleSort(int[] nums){
        //outer loop to go over n numbers
        for(int i=0; i<nums.length; i++){
            //inner loop to go over n numbers and keep swapping as long as nums[index-1]>nums[index]
            for(int j=1; j<nums.length; j++){
                if(nums[j-1]>nums[j]){
                    int tmp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }

    private static void printArray(int[] nums){
        for(int i: nums)
            System.out.print(i+",");
    }

}

package com.udays.algorithms.sorting;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

    public static void main(String... args){
        int[] nums = new int[]{6,2,8,4,3,10,7,5};
        mergeSort(nums);
        int[] expected = new int[]{2,3,4,5,6,7,8,10};
        printArray(nums);
        Assert.assertArrayEquals(expected, nums);
    }

    private static void mergeSort(int[] nums){
        //recursively split nums down until smallest units of 1, sort and merge
        mergeSortSublist(nums, 0, nums.length-1);
    }

    private static void mergeSortSublist(int[] nums, int l, int r){
        if(l<r){
            int m = l +(r-l)/2;
            //sort sublist from 0/left to mid
            mergeSortSublist(nums, l, m);
            //sort sublist from mid+1 to len/right
            mergeSortSublist(nums, m+1, r);
            //merge both sorted lists
            mergeSublist(nums, l, m, r);
        }
    }

    private static void mergeSublist(int[] nums, int l, int m, int r){
        //create new temp array for comparison
        int[] left = new int[m-l+1];
        int[] right = new int[r-m];
        //populate left with values from nums
        for(int i=0; i<left.length; i++){
            left[i] = nums[l+i];
        }
        //populate right with values from nums
        for(int i=0; i<right.length; i++){
            right[i] = nums[m+1+i];
        }
        //index for nums to be updated with correct value
        int k = l;
        //indexes to iterate over left and right arrays
        int i=0, j=0;
        while(i<left.length && j<right.length){
            //if left number is small, that comes first, else right
            if(left[i]<=right[j]){
                nums[k++]=left[i++];
            } else{
                nums[k++]=right[j++];
            }
        }
        //there should only be 1 extra element worst case in either left/right hence don't need to compare
        //add remaining numbers from left at the end
        while(i<left.length){
            nums[k++]=left[i++];
        }
        //add remaining numbers from right at the end
        while(j<right.length){
            nums[k++]=right[j++];
        }
    }

    private static void printArray(int[] nums){
        for(int i: nums)
            System.out.print(i+",");
    }

}

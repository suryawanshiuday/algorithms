package com.udays.algorithms.arrays;

import org.junit.Assert;

/**
 * Binary search with search space of 2
 *
 * Template #2 is an advanced form of Binary Search. It is used to search for an element or condition which requires accessing the current index and its immediate right neighbor's index in the array.
 *
 *
 *
 * Key Attributes:
 *
 * An advanced way to implement Binary Search.
 * Search Condition needs to access the element's immediate right neighbor
 * Use the element's right neighbor to determine if the condition is met and decide whether to go left or right
 * Guarantees Search Space is at least 2 in size at each step
 * Post-processing required. Loop/Recursion ends when you have 1 element left. Need to assess if the remaining element meets the condition.
 *
 * Note: DIFF means different from standard binary search
 */
public class BinarySearchII {

    public static void main(String... args) {
        int[] nums = new int[]{10,15,17,18,23,29,35,42,46,49,56,61,63,67,74,85,88,97,101};
        Assert.assertTrue(iterativeFind(nums, 10));
        Assert.assertTrue(iterativeFind(nums, 88));
        Assert.assertTrue(iterativeFind(nums, 101));
        Assert.assertFalse(iterativeFind(nums, 20));
    }

    public static boolean iterativeFind(int[] nums, int target){
        int start = 0;
        int end = nums.length;
        while(start<end){   //DIFF
            //prevent start+end overflow
            int mid = start+(end-start)/2;
            if(nums[mid]==target)
                return true;
            if(nums[mid]<target)
                start = mid+1;
            else
                end = mid;  //DIFF
        }

        //DIFF
        //Post processing
        //End condition start==end
        if(start!=nums.length && nums[start]==target) return true;

        //else return false
        return false;
    }

}

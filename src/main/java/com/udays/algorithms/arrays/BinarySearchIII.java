package com.udays.algorithms.arrays;

import org.junit.Assert;

/**
 * Binary search with search space of 2
 *
 * Template #3 is another unique form of Binary Search. It is used to search for an element or condition which requires accessing the current index and its immediate left and right neighbor's index in the array.
 *
 *
 *
 * Key Attributes:
 *
 * An alternative way to implement Binary Search
 * Search Condition needs to access element's immediate left and right neighbors
 * Use element's neighbors to determine if condition is met and decide whether to go left or right
 * Gurantees Search Space is at least 3 in size at each step
 * Post-processing required. Loop/Recursion ends when you have 2 elements left. Need to assess if the remaining elements meet the condition.
 *
 * Note: DIFF means different from standard binary search
 */
public class BinarySearchIII {

    public static void main(String... args) {
        int[] nums = new int[]{10,15,17,18,23,29,35,42,46,49,56,61,63,67,74,85,88,97,101};
        Assert.assertTrue(iterativeFind(nums, 10));
        Assert.assertTrue(iterativeFind(nums, 88));
        Assert.assertTrue(iterativeFind(nums, 101));
        Assert.assertFalse(iterativeFind(nums, 20));
    }

    public static boolean iterativeFind(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        while(start+1<end){   //DIFF
            //prevent start+end overflow
            int mid = start+(end-start)/2;
            if(nums[mid]==target)
                return true;
            if(nums[mid]<target)
                start = mid;    //DIFF
            else
                end = mid;      //DIFF
        }

        //DIFF
        //Post processing
        //We didn't check nums[0] and nums.length-1
        if(nums[end]==target || nums[start]==target)
            return true;

        //else return false
        return false;
    }

}

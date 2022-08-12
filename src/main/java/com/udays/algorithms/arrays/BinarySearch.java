package com.udays.algorithms.arrays;

import org.junit.Assert;

public class BinarySearch {

    public static void main(String... args) {
        int[] nums = new int[]{10,15,17,18,23,29,35,42,46,49,56,61,63,67,74,85,88,97,101};

        Assert.assertTrue(iterativeFind(nums, 10));
        Assert.assertTrue(iterativeFind(nums, 88));
        Assert.assertTrue(recursiveFind(nums, 88));
        Assert.assertTrue(iterativeFind(nums, 101));

        Assert.assertTrue(recursiveFind(nums, 10));
        Assert.assertTrue(recursiveFind(nums, 101));
        Assert.assertFalse(iterativeFind(nums, 20));
        Assert.assertFalse(recursiveFind(nums, 20));
    }

    public static boolean iterativeFind(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            //prevent start+end overflow
            int mid = start+(end-start)/2;
            if(nums[mid]==target)
                return true;
            if(nums[mid]<target)
                start = mid+1;
            if(nums[mid]>target)
                end = mid-1;
        }
        return false;
    }

    public static boolean recursiveFind(int[] nums, int target){
        return find(nums, 0, nums.length-1, target);
    }

    public static boolean find(int[] nums, int start, int end, int target){
        if(start>end)
            return false;
        int mid = start+(end-start)/2;
        if(nums[mid] == target)
            return true;
        if(nums[mid]<target)
            return find(nums, mid+1, end, target);
        else
            return find(nums, start, mid-1, target);
    }
}

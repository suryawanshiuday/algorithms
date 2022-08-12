package com.udays.algorithms.sorting;

import org.junit.Assert;

public class QuickSort {

    public static void main(String... args){
        int[] nums = new int[]{6,2,8,4,3,10,7,5};
        quickSort(nums);
        int[] expected = new int[]{2,3,4,5,6,7,8,10};
        printArray(nums);
        Assert.assertArrayEquals(expected, nums);
    }

    private static void quickSort(int[] nums){
        quickSortSublist(nums, 0, nums.length-1);
    }

    private static void quickSortSublist(int[] nums, int low, int high){
        if(low<high){
            //choose pivot and partition array
            //return pivot index, it will be its correct final position
            int pivot = partition(nums, low, high);
            //why pivot-1 and pivot+1? because pivot is already at correct position
            quickSortSublist(nums, low, pivot-1);
            quickSortSublist(nums, pivot+1, high);
        }
    }

    private static int partition(int[] nums, int low, int high)
    {
        //choosing pivot always to be last element
        int pivot = nums[high];
        //index of element to be swapped in case its < pivot
        int i = low-1;

        //iterate over nums from low to high
        //why high-1, because pivot is from index high
        for(int j=low; j<=high-1; j++){
            //if nums[j]<pivot, i++ and swap
            if(nums[j]<pivot){
                i++;
                swap(nums, i, j);
            }
        }
        //at the end swap pivot with i
        //why i+1, because after loop, we have all nums < pivot upto index i
        swap(nums, i+1, high);
        return i+1;
    }

    // A utility function to swap two elements
    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArray(int[] nums){
        for(int i: nums)
            System.out.print(i+",");
    }

}

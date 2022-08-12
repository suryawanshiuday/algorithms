package com.udays.algorithms.sorting;

import org.junit.Assert;

public class HeapSort {

    public static void main(String... args){
        int[] nums = new int[]{6,2,8,4,3,10,7,5};
        heapSort(nums);
        int[] expected = new int[]{2,3,4,5,6,7,8,10};
        printArray(nums);
        Assert.assertArrayEquals(expected, nums);
    }

    private static void heapSort(int[] nums){
        //build heap from nums and apply heapify
        //last non-leaf element for N elements = N/2-1
        //build the heap for every non-leaf element from n/2-1 upto 0
        int n = nums.length;
        for(int i=n/2-1; i>=0; i--){
            heapify(nums, n, i);
        }

        //now one by one, extract largest element from heap and swap that at the end of nums
        for(int i=n-1; i>0; i--){
            //max element will be at 0 after heapify
            swap(nums, 0, i);
            //once you remove max element from heap, heapify on reduced heap to rearrange if needed
            heapify(nums, i, 0);
        }
    }

    private static void heapify(int[] nums, int n, int i){
        //to heapify at index i, value[i]>left child and right child
        //initialize largest to be node itself
        int largest = i;
        //left node, because when creating tree from array, we build a complete binary tree
        int left = 2*i+1;
        //right node
        int right = 2*i+2;

        if(left<n && nums[left]>nums[largest])
            largest = left;
        if(right<n && nums[right]>nums[largest])
            largest = right;

        //swap numbers if largest is not root
        if(largest!=i){
            swap(nums, i, largest);
            //recursively heapify the subtree
            heapify(nums, n, largest);
        }
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

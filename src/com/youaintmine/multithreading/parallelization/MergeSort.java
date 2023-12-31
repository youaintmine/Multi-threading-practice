package com.youaintmine.multithreading.parallelization;

public class MergeSort {
    private Integer[] nums;
    private Integer[] tmp;

    public MergeSort(Integer[] nums){
        this.nums = nums;
        this.tmp = new Integer[nums.length];
    }

    public void sort() {
        mergeSort(0, nums.length-1);
    }

    private void mergeSort(int l, int r) {
        if(l>=r)
            return;

        int mid = (l + r)/2;
        mergeSort(l, mid);
        mergeSort(mid+1, r);
        merge(l, mid, r);
    }

    private void merge(int l, int mid, int r) {
        for(int i = l; i<=r; i++)
            tmp[i] = nums[i];

        int i=l, j = mid+1, k = l;

        while (i<=mid && j<=r){
            if(tmp[i] < tmp[j]){
                nums[k] = tmp[i];
                i++;
            }else {
                nums[k] = tmp[j];
                j++;
            }
            k++;
        }

        while (i<=mid){
            nums[k] = tmp[i];
            i++;k++;
        }
        while (j<=r) {
            nums[k] = tmp[j];
            j++;k++;
        }
    }

    public void printArray() {
        for(int i=0; i<nums.length; i++)
            System.out.print(nums[i] + ", ");
        System.out.println("");
    }

    private void swap(int a, int b){
        int tempVal = nums[a];
        nums[a] = nums[b];
        nums[b] = tempVal;
    }
}

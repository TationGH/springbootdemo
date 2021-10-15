package com.example.springbootdemo;

import java.util.Arrays;

/**
 * @Author Zts
 * @Date 2021/10/13 10:24 下午
 * @Classname QuickSort
 * @Description
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 2, 3};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = left;//设定基准值
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
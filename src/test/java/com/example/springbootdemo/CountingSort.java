package com.example.springbootdemo;

import java.util.Arrays;

/**
 * @Author Zts
 * @Date 2021/10/15 7:30 上午
 * @Classname CountingSort
 * @Description
 **/
public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 2, 3};
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        countingSort(arr, maxValue);
        System.out.println(Arrays.toString(arr));
    }

    private static void countingSort(int[] arr, int maxValue) {
        int bucketLen = maxValue + 1;
        int[] bucket = new int[bucketLen];

        for (int value : arr) {
            bucket[value]++;
        }

        int sortedIndex = 0;
        for (int j = 0; j < bucketLen; j++) {
            while (bucket[j] > 0) {
                arr[sortedIndex++] = j;
                bucket[j]--;
            }
        }
    }
}

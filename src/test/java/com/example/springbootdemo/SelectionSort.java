package com.example.springbootdemo;

import java.util.Arrays;

/**
 * @Author Zts
 * @Date 2021/10/12 7:43 上午
 * @Classname SelectionSort
 * @Description
 **/
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 2, 3};
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }

            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
        System.out.print(Arrays.toString(arr));
    }
}

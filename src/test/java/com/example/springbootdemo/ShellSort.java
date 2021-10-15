package com.example.springbootdemo;

import java.util.Arrays;

/**
 * @Author Zts
 * @Date 2021/10/13 6:34 上午
 * @Classname shellSort
 * @Description
 **/
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 2, 3};
        for (int step = arr.length / 2; step >= 1; step /= 2) {

            for (int i = step; i < arr.length; i++) {
                int temp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp;
            }
        }
        System.out.print(Arrays.toString(arr));
    }
}

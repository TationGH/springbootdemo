package com.example.springbootdemo;

import java.util.Arrays;

/**
 * @Author Zts
 * @Date 2021/10/13 9:40 下午
 * @Classname MergeSort
 * @Description
 **/
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 2, 3};
        arr = sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] sort(int[] arr) {
        //对 arr 进行拷贝，不改变参数内容
        int[] copyArr = Arrays.copyOf(arr, arr.length);
        if (copyArr.length < 2) {
            return copyArr;
        }

        int middle = (int) Math.floor(copyArr.length / 2);
        int[] left = Arrays.copyOfRange(copyArr, 0, middle);
        int[] right = Arrays.copyOfRange(copyArr, middle, copyArr.length);
        return merge(sort(left), sort(right));
    }

    protected static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return result;
    }
}
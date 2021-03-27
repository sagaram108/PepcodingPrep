package com.Recursion_in_arrays;

import java.util.Scanner;

public class Max_in_arr {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = scan.nextInt();

        int max = maxOfArray(arr, 0);
        System.out.println(max);

    }

    public static int maxOfArray(int[] arr, int idx){
        if (idx >= arr.length) return Integer.MIN_VALUE;

        int max = Math.max(arr[idx], maxOfArray(arr, idx+1));
        return max;
    }
}

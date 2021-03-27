package com.Recursion_in_arrays;

import java.util.Scanner;

public class First_index {
    public static void main(String[] args) throws Exception {
        // write your code here

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = scan.nextInt();

        int x = scan.nextInt();

        int findex = firstIndex(arr, 0, x);
        System.out.println(findex);
    }

    public static int firstIndex(int[] arr, int idx, int x){

        if (idx >= arr.length) return -1;

        if (arr[idx] == x) return idx;
        else return firstIndex(arr, idx+1, x);
    }
}

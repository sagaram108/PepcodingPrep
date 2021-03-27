//1. You are given a number n, representing the count of elements.
//2. You are given n numbers.
//3. You are given a number x.
//4. You are required to find the all indices at which x occurs in array a.
//5. Return an array of appropriate size which contains all indices at which x occurs in array a.

package com.Recursion_in_arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class All_occurance_indices {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int x = Integer.parseInt(br.readLine());
        int[] iarr = allIndices(arr, x, 0, 0);

        if(iarr.length == 0){
            System.out.println();
            return;
        }

        for(int i = 0; i < iarr.length; i++){
            System.out.println(iarr[i]);
        }
    }

    public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
        // write ur code here

        List<Integer> list = new ArrayList<>();
        addToList(arr, x, idx, list);
        return list.stream().mapToInt((Integer i) -> i).toArray();
    }

    private static void addToList(int[] arr, int x,int idx, List<Integer> list) {
        if (idx >= arr.length) return;
        if (arr[idx] == x) list.add(idx);

        addToList(arr, x, idx+1, list);
    }

}

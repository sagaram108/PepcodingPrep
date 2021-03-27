//1. You are given a number n representing number of stairs in a staircase.
//2. You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps in one move.
//3. Complete the body of getStairPaths function - without changing signature - to get the list of all paths that can be used to climb the staircase up.
//Use sample input and output to take idea about output.
package com.Recursion_in_ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Get_stairs_paths {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // no. of stairs

    }

    public static ArrayList<String> getStairPaths(int n)
    {

        for (int i=1; i<=n; i++) {
            ArrayList<String> rres = getStairPaths(n-1);
            ArrayList<String> res = new ArrayList<>();
            int j=0;
            for (var st: rres) {
                res.add(rres.get(j++));
            }

        }
        return null;
    }
}

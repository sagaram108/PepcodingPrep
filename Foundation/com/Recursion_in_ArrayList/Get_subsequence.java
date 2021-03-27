//1. You are given a string str.
//2. Complete the body of getSS function - without changing signature - to calculate all subsequences of str.
//Use sample input and output to take idea about subsequences.
//
//Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
//Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
package com.Recursion_in_ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Get_subsequence {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        ArrayList<String> res = gss(str);

        for (String s: res) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> gss(String str) {
        if (str.length() == 0) {
            ArrayList<String> baseRes = new ArrayList<>();
            baseRes.add("");
            return baseRes;
        }

        char ch = str.charAt(0);
        ArrayList<String> rightRes = gss(str.substring(1));

        ArrayList<String> res = new ArrayList<>();

        for (String rstr : rightRes) {
            res.add("" + rstr);
        }
        for (String rstr : rightRes) {
            res.add(ch + rstr);
        }
        return res;
    }
}

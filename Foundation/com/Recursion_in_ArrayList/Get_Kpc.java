package com.Recursion_in_ArrayList;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Get_Kpc {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        ArrayList<String> list = getKPC(str);

        for (int i=0; i<list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

    }
    static String[] matches = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static ArrayList<String> getKPC(String str) {
        if (str.length() == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list ;
        }
        ArrayList<String> rres = getKPC(str.substring(1));
        int btn = str.charAt(0) - '0';
        ArrayList<String> res = new ArrayList<>();
        String chars = matches[btn];

        for (int i=0; i<chars.length(); i++) {
            for (var st: rres) {
                res.add(chars.charAt(i) + st);
            }
        }
        return res;
    }

    public static List<Character>
    convertStringToCharList(String str)
    {
        return new AbstractList<Character>() {

            @Override
            public Character get(int index)
            {
                return str.charAt(index);
            }

            @Override
            public int size()
            {
                return str.length();
            }
        };
    }
}

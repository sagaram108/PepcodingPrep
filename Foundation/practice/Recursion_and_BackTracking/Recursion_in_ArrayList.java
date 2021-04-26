package practice.Recursion_and_BackTracking;

import java.util.ArrayList;
import java.util.Scanner;

public class Recursion_in_ArrayList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        ArrayList<String> out = get_Stair_Paths(n);
//        print_ArrayList(out);

        System.out.print("Rows ");
        int x = scanner.nextInt();
        System.out.print("Columns ");
        int y = scanner.nextInt();
//        ArrayList<String> res = get_Maze_Paths(1, 1, y, x);

        ArrayList<String> res = getMazePaths_with_Jumps(1, 1, x, y);
        System.out.println(res);
    }



//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//1. You are given a string str.
//2. Complete the body of getSS function - without changing signature - to calculate all subsequences of str.
//Use sample input and output to take idea about subsequences.
//
//Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
//Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

    public static ArrayList<String> get_Subsequence(String str) {
        if (str.length() == 0) {
            ArrayList<String> baseRes = new ArrayList<>();
            baseRes.add("");
            return baseRes;
        }

        char ch = str.charAt(0);
        ArrayList<String> rightRes = get_Subsequence(str.substring(1));

        ArrayList<String> res = new ArrayList<>();

        for (String rstr : rightRes) {
            res.add("" + rstr);
        }
        for (String rstr : rightRes) {
            res.add(ch + rstr);
        }
        return res;
    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//1. You are given a string str. The string str will contains numbers only, where each number stands for a key pressed on a mobile phone.
//2. The following list is the key to characters map :
//    0 -> .;
//    1 -> abc
//    2 -> def
//    3 -> ghi
//    4 -> jkl
//    5 -> mno
//    6 -> pqrs
//    7 -> tu
//    8 -> vwx
//    9 -> yz
//3. Complete the body of getKPC function - without changing signature - to get the list of all words that could be produced by the keys in str.
//Use sample input and output to take idea about output.

    static String[] matches = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    public static ArrayList<String> get_Key_pressed_combinations(String str) {
        if (str.length() == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list ;
        }
        ArrayList<String> rres = get_Key_pressed_combinations(str.substring(1));
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


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//1. You are given a number n representing number of stairs in a staircase.
//2. You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps in one move.
//3. Complete the body of getStairPaths function - without changing signature - to get the list of all paths that can be used to climb the staircase up.
//Use sample input and output to take idea about output.

    public static ArrayList<String> get_Stair_Paths(int n) {
        if(n == 0) {
            ArrayList<String> baseCase = new ArrayList<>();
            baseCase.add("");
            return baseCase;
        }
        else if (n < 0) { // not a valid answer

        }

        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> rres1 = new ArrayList<>();
        ArrayList<String> rres2 = new ArrayList<>();
        ArrayList<String> rres3 = new ArrayList<>();


        if (n >= 3) {
            rres1 = get_Stair_Paths(n-1);
            rres2 = get_Stair_Paths(n-2);
            rres3 = get_Stair_Paths(n-3);

            for (var st: rres1) {   res.add("1" + st);  }
            for (var st: rres2) {   res.add("2" + st);  }
            for (var st: rres3) {   res.add("3" + st);  }

        }
        else if (n >=2) {
            rres1 = get_Stair_Paths(n-1);
            rres2 = get_Stair_Paths(n-2);

            for (var st: rres1) {   res.add("1" + st);  }
            for (var st: rres2) {   res.add("2" + st);  }

        }
        else if (n >= 1) {
            rres1 = get_Stair_Paths(n-1);

            for (var st: rres1) {   res.add("1" + st);  }

        }


        return res;
    }


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// sRow - source row
// sCol - source column
// dRow - destination row
// dCol - destination column
    public static ArrayList<String> get_Maze_Paths(int sRow, int sCol, int dRow, int dCol) {
        if(sRow == dRow && sCol == dCol) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> vertical_paths = new ArrayList<>();
        ArrayList<String> horizontal_paths = new ArrayList<>();

        if (sCol < dCol) { // we'hv to move right
            horizontal_paths = get_Maze_Paths(sRow, sCol+1, dRow, dCol);    }
        if (sRow < dRow) { // we'hv to move down
            vertical_paths = get_Maze_Paths(sRow+1, sCol, dRow, dCol);  }

        ArrayList<String> res_paths = new ArrayList<>();

        for (var st: horizontal_paths) { // for every paths from (n+1)th col
            res_paths.add("h" + st);  }

        for (var st: vertical_paths) {
            res_paths.add("v" + st);  }

        return res_paths;
    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//1. You are given a number n and a number m representing number of rows and columns in a maze.
//2. You are standing in the top-left corner and have to reach the bottom-right corner.
//3. In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ), or 1 or more steps vertically (as v1, v2, ..) or 1 or more steps diagonally (as d1, d2, ..).
//4. Complete the body of getMazePath function - without changing signature - to get the list of all paths that can be used to move from top-left to bottom-right.
//Use sample input and output to take idea about output.
    public static ArrayList<String> getMazePaths_with_Jumps(int sr, int sc, int dr, int dc) {
        if(sr == dr && sc == dc) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> vertical_paths = new ArrayList<>();
        ArrayList<String> horizontal_paths = new ArrayList<>();

        ArrayList<String> mypaths = new ArrayList<>();
        // Vertical-move
        for (int hjump=1; hjump<= dc-sc; hjump++) {
            ArrayList<String> hpaths = getMazePaths_with_Jumps(sr, sc + hjump, dr, dc);
            for (var path: hpaths) {
                mypaths.add("h" + hjump + path); // hjump :- jump of 1,2,3,..
            }
        }
        // Horizontal-move
        for (int vjump=1; vjump<= dr-sr; vjump++) {
            ArrayList<String> vpaths = getMazePaths_with_Jumps(sr + vjump, sc, dr, dc);
            for (var path: vpaths) {
                mypaths.add("v" + vjump + path);
            }
        }
        // Diagonal-move
        for (int djump=1; djump<=dc-sc && djump<=dr-sr; djump++) {
            ArrayList<String> dpaths = getMazePaths_with_Jumps(sr + djump, sc + djump, dr, dc);
            for (var path: dpaths) {
                mypaths.add("d" + djump + path);
            }
        }

        return mypaths;
    }
}

package practice.Recursion_and_BackTracking;

public class Recursion_on_the_way_up {
    public static void main(String[] args) {
        print_Encodings("123", "");
//        print_Keypad_combinations("132", "");
//        print_Subsequences("abcdefghijklmnopqrstuv", "");
    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//1. You are given a string str.
//2. Complete the body of printSS function - without changing signature - to calculate and print all subsequences of str.
//Use sample input and output to take idea about subsequences.

    public static void print_Subsequences(String ques, String ans) {
        // base case
        if (ques.length() == 0) {
            System.out.print(ans + " ");
            return;
        }

        String restQues = ques.substring(1);
        char ch = ques.charAt(0);
        print_Subsequences(restQues, ans + "");
        print_Subsequences(restQues, ans + ch);
    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//1. You are given a string str. The string str will contains numbers only, where each number stands for a key pressed on a mobile phone.
//2. The following list is the key to characters map
//    0 -> .;
//   1 -> abc
//   2 -> def
//   3 -> ghi
//   4 -> jkl
//   5 -> mno
//   6 -> pqrs
//   7 -> tu
//   8 -> vwx
//   9 -> yz
//3. Complete the body of printKPC function - without changing signature - to print the list of all words that could be produced by the keys in str.
//Use sample input and output to take idea about output.

    static String[] keyStrPairs = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static void print_Keypad_combinations(String ques, String ans) {
        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        }

        int num = ques.charAt(0) - '0';
        String keyStr = keyStrPairs[num];
        for (int i=0; i<keyStr.length(); i++) {
            char ci = keyStr.charAt(i);
            print_Keypad_combinations(ques.substring(1), ans + ci);
        }
    }


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    1. You are given a number n representing number of stairs in a staircase.
//2. You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps in one move.
//3. Complete the body of printStairPaths function - without changing signature - to print the list of all paths that can be used to climb the staircase up.

    public static void print_Stair_Paths(int n, String path) {
        if(n == 0) {
            System.out.println(path);
            return;
        }
        if(n < 0) return;

        for(int i=1; i<=3; i++) {
            print_Stair_Paths(n-i, path + i);
        }
    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// sr - source row
// sc - source column
// dr - destination row
// dc - destination column
    public static void print_maze_paths(int sr, int sc, int dr, int dc, String path) {
        if(sr == dr && sc == dc) {
            System.out.println(path);
            return;
        }
        if(sc < dc) {
            print_maze_paths(sr, sc+1, dr, dc, path + 'h');
        }
        if(sr < dr) {
            print_maze_paths(sr+1, sc, dr, dc, path + 'v');
        }
    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//1. You are given a number n and a number m representing number of rows and columns in a maze.
//2. You are standing in the top-left corner and have to reach the bottom-right corner.
//3. In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ), or 1 or more steps vertically (as v1, v2, ..) or 1 or more steps diagonally (as d1, d2, ..).
//4. Complete the body of printMazePath function - without changing signature - to print the list of all paths that can be used to move from top-left to bottom-right.
    public static void print_Maze_Paths_With_Jumps(int sr, int sc, int dr, int dc, String path) {
//        base case
        if (sr == dr && sc == dc) {
            System.out.println(path);
            return;
        }

        for (int i=1; i<=dc-sc; i++) {
            print_Maze_Paths_With_Jumps(sr, sc+i, dr, dc, path + 'h' + i);
        }
        for (int j=1; j<=dr-sr; j++) {
            print_Maze_Paths_With_Jumps(sr+j, sc, dr, dc, path + 'v' + j);
        }
        for (int k=1; k<=dc-sc && k<=dr-sr; k++) {
            print_Maze_Paths_With_Jumps(sr+k, sc+k, dr, dc, path + 'd' + k);
        }
    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//1. You are given a string str.
//2. Complete the body of printPermutations function - without changing signature - to calculate and print all permutations of str.
//Use sample input and output to take idea about permutations.
    public static void print_Permutations(String ques, String ans) {

        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        }

        StringBuilder sb = new StringBuilder(ques);
        for (int i=0; i< ques.length(); i++) {
            char c = ques.charAt(i);
            sb.deleteCharAt(i);
            print_Permutations(sb.toString(), ans + c);
        }
    }


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//1. You are given a string str of digits. (will never start with a 0)
//2. You are required to encode the str as per following rules
//    1 -> a
//    2 -> b
//    3 -> c
//    ..
//    25 -> y
//    26 -> z
//3. Complete the body of printEncodings function - without changing signature - to calculate and print all encodings of str.
//Use the input-output below to get more understanding on what is required
//123 -> abc, aw, lc
//993 -> iic
//013 -> Invalid input. A string starting with 0 will not be passed.
//103 -> jc
//303 -> No output possible. But such a string maybe passed. In this case print nothing.

    public static void print_Encodings(String ques, String ans) {
        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        }
        else if (ques.length() == 1) {
            char ch = ques.charAt(0);
            if (ch == '0')
                return;
            else {
                int chv = ch - '0';
                char code = (char)('a' + chv - 1);
                System.out.println(ans + code);
            }
        }
        else {
            char ch = ques.charAt(0);
            if (ch == '0')
                return;
            else {
                int chv = ch - '0';
                char code = (char)('a' + chv - 1);
                print_Encodings(ques.substring(1), ans + code);
            }

            String ch12 = ques.substring(0,2);
            int chv = Integer.parseInt(ch12);
            if (chv <= 26) {
                char code = (char) ('a' + chv - 1);
                print_Encodings(ques.substring(2), ans + code);
            }else return;
        }
    }

}

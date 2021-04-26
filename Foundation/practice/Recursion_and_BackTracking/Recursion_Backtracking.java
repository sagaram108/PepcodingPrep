package practice.Recursion_and_BackTracking;

import java.util.Scanner;

public class Recursion_Backtracking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] chess = new int[n][n];

        printKnightsTour(chess, 2, 0, 1);

//        print_N_Queens(chess, "", 0);


//        Subset sum --or-- target sum

//        int n = scan.nextInt();
//        int[] a = new int[n];
//        for(int i=0; i<n; i++) {
//            a[i] = scan.nextInt();
//        }
//        int tar = scan.nextInt();
//

//        print_Target_Sum_Subset_BackTracking(a, 0, "", 0, tar);

//        subset_sum(a, 0, 0, "", tar);

//        ----flood fill ----
//        int n = scn.nextInt();
//        int m = scn.nextInt();
//        int[][] arr = new int[n][m];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                arr[i][j] = scn.nextInt();
//            }
//        }
//
//        boolean[][] visited = new boolean[n][m];
//        flood_Fill(arr, 0, 0, "", visited);
    }


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//1. You are given a number n, representing the number of rows.
//2. You are given a number m, representing the number of columns.
//3. You are given n*m numbers, representing elements of 2d array a. The numbers can be 1 or 0 only.
//4. You are standing in the top-left corner and have to reach the bottom-right corner.
//Only four moves are allowed 't' (1-step up), 'l' (1-step left), 'd' (1-step down) 'r' (1-step right). You can only move to cells which have 0 value in them. You can't move out of the boundaries or in the cells which have value 1 in them (1 means obstacle)
//5. Complete the body of floodfill function - without changing signature - to print all paths that can be used to move from top-left to bottom-right.
//
//Note1 -> Please check the sample input and output for details
//Note2 -> If all four moves are available make moves in the order 't', 'l', 'd' and 'r'

    public static void flood_Fill(int[][] arr, int row, int col, String pathSoFar,
                                  boolean[][] visited) {
//        base case
        if (row < 0 || col < 0 || row == arr.length || col == arr[0].length || arr[row][col] == 1 ||
            visited[row][col] == true)
            return;

        if (row == arr.length-1 && col == arr[0].length-1){
            System.out.println(pathSoFar);
            return;
        }

        visited[row][col] = true;

        flood_Fill(arr, row-1, col, pathSoFar + 't', visited);
        flood_Fill(arr, row, col-1, pathSoFar + 'l', visited);
        flood_Fill(arr, row+1, col, pathSoFar + 'd', visited);
        flood_Fill(arr, row, col+1, pathSoFar + 'r', visited);
    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//1. You are given a number n, representing the count of elements.
//2. You are given n numbers.
//3. You are given a number "tar".
//4. Complete the body of printTargetSumSubsets function - without changing signature - to calculate and print all subsets of given elements, the contents of which sum to "tar". Use sample input and output to get more idea.

    // Recursive
    public static void print_Target_Sum_Subsets(int[] arr, int idx, String set, int sumOfSubset, int target) {
        if(idx == arr.length) {
            if(sumOfSubset == target)
                System.out.println(set + ".");
            return;
        }

        print_Target_Sum_Subsets(arr, idx + 1, set + arr[idx] + ", ", sumOfSubset + arr[idx], target);
        print_Target_Sum_Subsets(arr, idx + 1, set, sumOfSubset, target);
    }
//    Testcase failed -
//27
//20
//17
//7
//2
//20
//16
//13
//6
//20
//5
//15
//4
//7
//15
//18
//17
//11
//4
//3
//0
//19
//18
//11
//10
//8
//6
//12
//8

// Expected-
//2, 6, 0, .
//2, 6, .
//2, 0, 6, .
//2, 6, .
//5, 3, 0, .
//5, 3, .
//4, 4, 0, .
//4, 4, .
//0, 8, .
//8, .

//    My output
//    --nothing--


//    public static void print_Target_Sum_Subset_BackTracking(int[] arr, int idx, String set, int sos, int tar) {
//        if (sos == tar) {
//            System.out.println(idx+ "--" +set);
//            if (idx < arr.length) {
//
//                int lNum = arr[idx-1];
//                String s = lNum + ", ";
//                set = set.substring(0, set.lastIndexOf(s));
//                print_Target_Sum_Subset_BackTracking(arr, idx, set, sos - arr[idx-1], tar);
//            }
//
//        }
//        else {
//            for (int i=idx; i<arr.length; i++) {
//                print_Target_Sum_Subset_BackTracking(arr, idx + 1, set + arr[idx] + ", ", sos + arr[idx], tar);
//            }
//        }
//    }
//
//    public static void subset_sum(int list[], int sum, int starting_index, String set, int target_sum)
//    {
//        if( target_sum == sum )
//        {
//            System.out.println(set);
//            if(starting_index < list.length) {
//                String s = list[starting_index-1] + ", ";
//                set = set.substring(starting_index, set.lastIndexOf(s));
//                subset_sum(list, sum - list[starting_index-1], starting_index,set, target_sum);
//            }
//        }
//        else
//        {
//            for( int i = starting_index; i < list.length; i++ )
//            {
//                subset_sum(list, sum + list[i], i + 1,set + list[i] + ", ",  target_sum);
//            }
//        }
//    }


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//1. You are given a number n, the size of a chess board.
//2. You are required to place n number of queens in the n * n cells of board such that no queen can kill another.
//Note - Queens kill at distance in all 8 directions
//3. Complete the body of printNQueens function - without changing signature - to calculate and print all safe configurations of n-queens. Use sample input and output to get more idea.

    public static void print_N_Queens(int[][] chess, String qsf, int row) {
        if (row == chess.length) {
            System.out.println(qsf); // print output
            return;
        }
        for (int col=0; col<chess.length; col++) {
            if(isPlace_SafeFor_Queen(chess, row, col)) {
                chess[row][col] = 1;
                print_N_Queens(chess, qsf + row + "-" + col + "\t", row + 1);
                chess[row][col] = 0;
            }
        }
    }

    private static boolean isPlace_SafeFor_Queen(int[][] chess, int row, int col) {
        for (int i=row-1; i>=0; i--)
            if (chess[i][col] == 1)
                return false;

        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--)
            if (chess[i][j] == 1)
                return false;


        for (int i=row-1, j=col+1; i>=0 && j< chess.length; i--, j++)
            if (chess[i][j] == 1)
                return false;

        return true;
    }


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//1. You are given a number n, the size of a chess board.
//2. You are given a row and a column, as a starting point for a knight piece.
//3. You are required to generate the all moves of a knight starting in (row, col) such that knight visits
//     all cells of the board exactly once.
//4. Complete the body of printKnightsTour function - without changing signature - to calculate and
//     print all configurations of the chess board representing the route
//     of knight through the chess board. Use sample input and output to get more idea.
//
//Note -> When moving from (r, c) to the possible 8 options give first precedence to (r - 2, c + 1) and
//               move in clockwise manner to
//               explore other options.

    public static void printKnightsTour(int[][] chess, int row, int col, int move) {
        // base case
        if (row < 0 || col < 0 || row >= chess.length || col >= chess.length ||
            chess[row][col] > 0)
            return;
        else if (move == chess.length * chess.length) {
            chess[row][col] = move;
            displayBoard(chess);
            chess[row][col] = 0;
            return;
        }

        chess[row][col] = move;
        printKnightsTour(chess, row-2, col+1, move+1);
        printKnightsTour(chess, row-1, col+2, move+1);
        printKnightsTour(chess, row+1, col+2, move+1);
        printKnightsTour(chess, row+2, col+1, move+1);
        printKnightsTour(chess, row+2, col-1, move+1);
        printKnightsTour(chess, row+1, col-2, move+1);
        printKnightsTour(chess, row-1, col-2, move+1);
        printKnightsTour(chess, row-2, col-1, move+1);
        chess[row][col] = 0;
    }

    private static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}

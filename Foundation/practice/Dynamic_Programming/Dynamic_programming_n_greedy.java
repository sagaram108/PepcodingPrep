package practice.Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_programming_n_greedy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        0-1 knapsack problem
        int n = scan.nextInt();
        int[] weigh = new int[n];
        int[] vals = new int[n];

        for (int i = 0; i < n; i++) {
            vals[i] = scan.nextInt();
        }
        for (int i = 0; i < n; i++) {
            weigh[i] = scan.nextInt();
        }
        int capacity = scan.nextInt();
        int res = unbounded_knapsack(capacity, weigh, vals);
        System.out.println(res);

////        int res = zero_one_Knapsack(capacity, weigh, vals);
//        int n = scan.nextInt();
//        int[] coins = new int[n];
//        for (int i=0; i<n; i++)
//            coins[i] = scan.nextInt();
//
//        int sumRequired = scan.nextInt();
//        int res = coin_change_permutation(coins, sumRequired);
//        System.out.println(res);


//        int res = coin_change_combination(coins, sumRequired);
//        System.out.println(res);


//        int res = coin_change_combination()


//        int n = scan.nextInt();
//        int [] runs = new int[n];
//        for (int i =0; i< n; i++)
//            runs[i] = scan.nextInt();
//        int requiredRun = scan.nextInt();
//        boolean bool = target_sum_subsets(runs, requiredRun);
//        System.out.println(bool);

//        int n = scan.nextInt();
//        int m = scan.nextInt();
//        int[][] maze = new int[n][m];
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<m; j++) {
//                maze[i][j] = scan.nextInt();
//            }
//        }
//
//        int res = gold_mine(maze);
//        System.out.println(res);

//
//        int res = min_cost_in_maze_traversal(maze );
//        System.out.println(res);

//        int n = scan.nextInt();
//        int[] jumps = new int[n];
//        for (int i=0; i<n; i++)
//            jumps[i] = scan.nextInt();

//~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~

//        int n = scan.nextInt();
//        int[] jumps = new int[n];
//        for (int i=0; i<n; i++)
//            jumps[i] = scan.nextInt();
//        Integer[] dp = new Integer[n+1];
//        int res = min_jump_moves_to_reach_at_top(n, jumps, dp);
//        System.out.println(res);

//~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~
//        int n = scan.nextInt();
//        int[] jumps = new int[n];
//        for (int i=0; i<n; i++)
//            jumps[i] = scan.nextInt();
//        int[] dp = new int[n+1];
//        int res = climb_stairs_with_variable_jumps(n, jumps, dp);
//        System.out.println(res);

//        int total = climb_stairs(n, dp);
//        System.out.println(total);

//        int n = scan.nextInt();
//        int[] dp = new int[n+1];
//        dp[0] = 0;
//        dp[1] = 1;
//        int fibn = nth_fibonacci(n, dp);
//        System.out.println(fibn);
    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//1. You are given a number n.
//2. You are required to print the nth element of fibonnaci sequence.
//
//Note -> Notice precisely how we have defined the fibonnaci sequence
//0th element -> 0
//1st element -> 1

    public static int nth_fibonacci(int n, int[] dp) {
        if (n == 0)
            return 0;

        if (dp[n] == 0 && n!=0) {
            if (dp[n-1] == 0)
                dp[n-1] = nth_fibonacci(n-1, dp);

            if (dp[n-2] == 0)
                dp[n-2] = nth_fibonacci(n-2, dp);

            dp[n] = dp[n-1] + dp[n-2];
            return dp[n];
        }
        else return dp[n];

    }


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//1. You are given a number n, representing the number of stairs in a staircase.
//2. You are on the 0th step and are required to climb to the top.
//3. In one move, you are allowed to climb👉🏻👉🏻▶🗯↪⏭➡🤜🏻🔥🔥 1, 2 or 3 stairs👈🏻👈🏻.
//4. You are required to print the number of different paths via which you can climb to the top.
    public static int climb_stairs(int n, int[] dp) {
        if (n < 0) return 0;

        if (dp[n] != 0) return dp[n];

        if (n == 0)
            dp[0] = 1;
        else if (n == 1) {
            dp[1] = climb_stairs(0, dp);
        }
        else if (n == 2) {
            dp[2] = climb_stairs(1, dp) + climb_stairs(0, dp); // paths upto 0(jump from 0) + paths upto 1(jump from 1)
        }
        else if (n > 2)
            dp[n] = climb_stairs(n-1, dp) + climb_stairs(n-2, dp) + climb_stairs(n-3, dp);

        return dp[n];
    }


//::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: :::
//1. You are given a number n, representing the number of stairs in a staircase.
//2. You are on the 0th step and are required to climb to the top.
//3. You are given n numbers, where ith element's value represents - till how far from the step you
//     could jump to in a single move.
//     You can of course jump fewer number of steps in the move.
//4. You are required to print the number of different paths via which you can climb to the top.


//    How to solve the DP problem - tabulation method
//    👇🏻
//    1/1. Storage & meaning        1/1 mean 1 of 1
//    2/1. Direction identify
//    3/1. Travel & Solve

    public static int climb_stairs_with_variable_jumps(int n, int[] jumps, int[] dp) {
        dp[0] = 1;
        for (int step=0; step<=n-1; step++) {
            for (int i = 1; i <= jumps[step] && step+i<=n; i++) {
                dp[step+i] += dp[step];
            }
        }
        return dp[n];
    }

//    public static int climbStairs(int n, int[] jumps) {
//        int[] dp = new int[n+1];
//        for (int i=n-1; i>=0; i--) {
//
//        }
//    }

//=== === === === === === === === === === === === === === === === === === === === ===
//1. You are given a number n, representing the number of stairs in a staircase.
//2. You are on the 0th step and are required to climb to the top.
//3. You are given n numbers, where ith element's value represents - till how far from the step you
//     could jump to in a single move.  You can of-course fewer number of steps in the move.
//4. You are required to print the number of minimum moves in which you can reach the top of
//     staircase.
//Note -> If there is no path through the staircase print null.

//    public static int min_jump_moves_to_reach_at_top(int n, int[] jumps, Integer[] dp) {
//        dp[n] = 0; // 0 move for same place
//        for (int i=n-1; i>=0; i--) {
//            int min = Integer.MAX_VALUE; // initial val assign to min
//            for (int j=1; j<=jumps[i] && i+j<=n; j++) {
//                if (dp[i+j] != null) {
//                    min = Math.min(min, dp[i+j]);
//                }
//            }
//            if (min != Integer.MAX_VALUE)
//                dp[i] = 1 + min;
//        }
//        return dp[0];
//    }


    public static int min_jump_moves_to_reach_at_top(int n, int[] jumps, Integer[] dp) {
        dp[0] = 1;
        for (int step=0; step<=n-1; step++) {
            for (int i = 1; i <= jumps[step] && dp[step] != null && step+i<=n; i++) {
                if (dp[step + i] != null && step != 0) {
                    dp[step + i] = Math.min(dp[step + i] , 1 + dp[step]);
                }
                else if (dp[step + i] != null && step == 0) {
                    dp[step + i] = Math.min(dp[step + i] , dp[step]);
                }
                else if (step == 0) { // && dp[step + i] == null
                    dp[step+i] = dp[step]; // 1
                }
                else dp[step + i] = 1 + dp[step]; // && dp[step + i] == null
            }
        }
        return dp[n];
    }


    public static void intFill(int[] array, int value) {
        int len = array.length;
        if (len > 0)
            array[0] = value;
        for (int i = 1; i < len; i += i)
            System.arraycopy( array, 0, array, i,
                    ((len - i) < i) ? (len - i) : i);
    }

//=== === === === === === === === === === === === === === === === === === === === ===
//1. You are given a number n, representing the number of rows.
//2. You are given a number m, representing the number of columns.
//3. You are given n*m numbers, representing elements of 2d array a, which represents a maze.
//4. You are standing in top-left cell and are required to move to bottom-right cell.
//5. You are allowed to move 1 cell right (h move) or 1 cell down (v move) in 1 motion.
//6. Each cell has a value that will have to be paid to enter that cell (even for the top-left and bottom-
//     right cell).
//7. You are required to traverse through the matrix and print the cost of path which is least costly.

    public static int min_cost_in_maze_traversal(int[][] maze) {
        int[][]dp = new int[maze.length][maze[0].length];

        for (int i=dp.length-1; i>=0; i--) {
            for (int j=dp[0].length-1; j>=0; j--) {
                if (i == dp.length-1 && j == dp[0].length-1) { // bottom-right corner
                    dp[i][j] = maze[i][j];
                }
                else if (i == dp.length-1) { // bottom-most row
                    dp[i][j] = dp[i][j+1] + maze[i][j];
                }
                else if (j == dp[0].length-1) { // right-most col
                    dp[i][j] = dp[i+1][j] + maze[i][j];
                }
                else { // rest section out of above three
                    int min = Math.min(dp[i][j+1], dp[i+1][j]);
                    dp[i][j] = min + maze[i][j];
                }
            }
        }
        return dp[0][0];
    }

//::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: :::
//1. You are given a number n, representing the number of rows.
//2. You are given a number m, representing the number of columns.
//3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
//4. You are standing in front of left wall and are supposed to dig to the right wall. You can start from
//     any row in the left wall.
//5. You are allowed to move 1 cell right-up (d1), 1 cell right (d2) or 1 cell right-down(d3).
//
//<img src="http://pepcoding.com/resources/ojquestionresource/images/goldmine.JPEG" alt="goldmine">
//
//6. Each cell has a value that is the amount of gold available in the cell.
//7. You are required to identify the maximum amount of gold that can be dug out from the mine.

    public static int gold_mine(int[][] maze) {
        int r = maze.length;
        int c = maze[0].length;
        int[][] dp = new int[r][c];

        int max = Integer.MIN_VALUE;

        for (int j=c-1; j>=0; j--) {
            for (int i=0; i<r; i++) {
                if (j==c-1) {
                    dp[i][j] = maze[i][j];
                }
                else if (i == 0) {
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j+1]) + maze[i][j];
                }
                else if (i == r-1) {
                    dp[i][j] = Math.max(dp[i-1][j+1], dp[i][j+1]) + maze[i][j];
                }
                else {
                    dp[i][j] =  Math.max(Math.max(dp[i-1][j+1], dp[i][j+1]), dp[i+1][j+1]) + maze[i][j];
                }

                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }


//::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: :::
//1. You are given a number n, representing the count of elements.
//2. You are given n numbers.
//3. You are given a number "tar".
//4. You are required to calculate and print true or false, if there is a subset the elements of which add
//     up to "tar" or not.

    public static boolean target_sum_subsets(int[] runs, int requiredRun) {
        boolean[][] dp = new boolean[runs.length + 1][requiredRun + 1];

        for (int i=0; i<dp.length; i++) {
            for (int j=0; j<dp[0].length; j++) {
                if (i==0 && j!=0)
                    dp[i][j] = false;
                else if (j==0) //dp[0][0] will be true
                    dp[i][j] = true;
                else {
                    int run = runs[i-1]; // dp.length = runs.length+1
                    if (j==run && i!=0)
                        dp[i][j] = true;
                    else if (dp[i - 1][j])
                        dp[i][j] = true;
                    else if (j-run >=0 && dp[i - 1][j - run] == true)
                        dp[i][j] = true;
                    else dp[i][j] = false;
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }


//::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: :::
//1. You are given a number n, representing the count of coins.
//2. You are given n numbers, representing the denominations of n coins.
//3. You are given a number "amt".
//4. You are required to calculate and print the number of combinations of the n coins using which the
//     amount "amt" can be paid.
//
//Note1 -> You have an infinite supply of each coin denomination i.e. same coin denomination can be
//                  used for many installments in payment of "amt"
//Note2 -> You are required to find the count of combinations and not permutations i.e.
//                  2 + 2 + 3 = 7 and 2 + 3 + 2 = 7 and 3 + 2 + 2 = 7 are different permutations of same
//                  combination. You should treat them as 1 and not 3.

    public static int coin_change_combination(int[] coins, int sum) {
        int[] dp = new int[sum+1];
        dp[0] = 1; // 1 way of making sum=0 is that not to include anyone
        for (int coin : coins) { // let coins : 2,3,5 then this loop will be serial-wise from 2,3 to  5
            for (int j=coin; j<=sum; j++) {
                dp[j] += dp[j-coin];
            }
        }
        return dp[sum];
    }

//::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: :::
//1. You are given a number n, representing the count of coins.
//2. You are given n numbers, representing the denominations of n coins.
//3. You are given a number "amt".
//4. You are required to calculate and print the number of permutations of the n coins using which the
//     amount "amt" can be paid.
//
//Note1 -> You have an infinite supply of each coin denomination i.e. same coin denomination can be
//                  used for many installments in payment of "amt"
//Note2 -> You are required to find the count of permutations and not combinations i.e.
//                  2 + 2 + 3 = 7 and 2 + 3 + 2 = 7 and 3 + 2 + 2 = 7 are different permutations of same
//                  combination. You should treat them as 3 and not 1.

    public static int coin_change_permutation(int[] coins, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int i=1; i<=sum; i++) {
            for (var coin: coins) {
                if (i<coin) continue;
                dp[i] += dp[i-coin];
            }
        }
        return dp[sum];
    }

//::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: ::: :::
//A number n
//v1 v2 .. n number of elements
//w1 w2 .. n number of elements
//A number cap

    public static int zero_one_Knapsack(int capacity, int[] thingWeigh, int[] thingVal) {
        int totalItems = thingVal.length;
        int[][] dp = new int[totalItems + 1][capacity + 1]; // dp[i][j] :: i=no. of rows, j=no. of cols

        for (int i = 0; i <= totalItems; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i==0 || j==0)
                    dp[i][j] = 0;

                else {
                    if (j >= thingWeigh[i-1]) {
                        int max = Math.max(dp[i-1][j], thingVal[i-1] + dp[i-1][j-thingWeigh[i-1]]); // first parameter: thing(j-1) willn't do batting, 2nd parameter: thing(j-1) will do batting
                        dp[i][j] = max;
                    }else
                        dp[i][j] = dp[i-1][j]; // thing(j-1) will not do batting, as he hasn't sufficient balls left to play, and he play only given num. of balls if he plays
                }
            }
        }
        return dp[totalItems][capacity];
    }


//1. You are given a number n, representing the count of items.
//2. You are give   n n numbers, representing the values of n items.
//3. You are given n numbers, representing the weights of n items.
//3. You are given a number "cap", which is the capacity of a bag you've.
//4. You are required to calculate and print the maximum value that can be created in the bag without
//    overflowing it's capacity.
//Note -> Each item can be taken any number of times. You are allowed to put the same item again
//                  and again.

    public static int unbounded_knapsack(int capacity, int[] weight, int[] value) { // repetition allowed
//        repetitive occurrence of things permitted
        // so we'll make 1D array
        int[] dp = new int[capacity + 1];

        dp[0] = 0;

        int n = weight.length;
        // coin change permutation --style
            for (int capi = 1; capi <= capacity; capi++) {
                int max = 0;
                for (int item = 0; item < n; item++) {
                if (weight[item] <= capi) { // item can be put into bag of weight(capi)
                    int remCap = capi - weight[item];
                    int preBagVal = dp[remCap];
                    int bagVal = preBagVal + value[item];
                    max = Math.max(max, bagVal);
                    dp[capi] = max;
                }
            }
        }
        return dp[capacity];
    }

//1. You are given a number n, representing the count of items.
//2. You are given n numbers, representing the values of n items.
//3. You are given n numbers, representing the weights of n items.
//3. You are given a number "cap", which is the capacity of a bag you've.
//4. You are required to calculate and print the maximum value that can be created in the bag without overflowing it's capacity.
//Note1 -> Items can be added to the bag even partially. But you are not allowed to put same items again and again to the bag.

// multiple occurrence of an item is not allowed
    public static int fractional_knapsack(int capacity, int[] weigh, int[] value) {


        return 0;
    }

}

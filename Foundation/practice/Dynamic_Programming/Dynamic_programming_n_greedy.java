package practice.Dynamic_Programming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dynamic_programming_n_greedy {
    public static void main(String[] args) {

        best_time_to_buy_n_sell_stocks_Two_transaction_allowed();

//        buy_n_sell_stocks_with_cooldown__Infinite_transaction_allowed();

//        buy_n_sell_stocks_with_Transaction_Fee_Infinite_transaction_allowed();

//        buy_n_sell_stocks_1_transaction_allowed();

//        partition_into_subsets();

//        friends_pairing();

//        Scanner scan = new Scanner(System.in);
//
//        int n = scan.nextInt();
//        int c = scan.nextInt();
//        int[][] arr = new int[n/*rows*/][c/*cols*/];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < c; j++) {
//                arr[i][j] = scan.nextInt();
//            }
//        }
//        long ans = paint_houses_many_colors(arr);
//        System.out.println(ans);

/*        int n = scan.nextInt();
        int[][] arr = new int[n*//*no. of rows(house)*//*][3*//*no. of cols(colors)*//*];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scan.nextInt();
            arr[i][1] = scan.nextInt();
            arr[i][2] = scan.nextInt();
        }
        long ans = paint_houses(n, arr);
        System.out.println(ans);*/


/*        int n = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        int ans = maximum_sum_non_adjacent_element_selection(a);
        System.out.println(ans);*/

/*
        String str = scan.next();
        int res = count_aPlus_bPlus_cPlus_subsequences(str);
        System.out.println(res);*/


/*        String str = scan.next();
        int res = count_encodings(str);
        System.out.println(res);*/


/*        int n = scan.nextInt();
        long res = arrange_buildings(n);
        System.out.println(res);*/



/*        int n = scan.nextInt();
        int res = count_binary_strings_of_length(n);
        System.out.println(res);*/


/*        int n = scan.nextInt();
        int[] weigh = new int[n];
        int[] vals = new int[n];

        for (int i = 0; i < n; i++) {
            vals[i] = scan.nextInt();
        }
        for (int i = 0; i < n; i++) {
            weigh[i] = scan.nextInt();
        }
        int capacity = scan.nextInt();
        double res = fractional_knapsack(capacity, weigh, vals);
        System.out.println(res);*/

        /*0-1 knapsack problem*/
/*        int n = scan.nextInt();
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
        System.out.println(res);*/

        /*!! copy paste the above code(unbounded knapsack)*/
        /*int res = zero_one_Knapsack(capacity, weigh, vals);*/



/*        int n = scan.nextInt();
        int[] coins = new int[n];
        for (int i=0; i<n; i++)
            coins[i] = scan.nextInt();

        int sumRequired = scan.nextInt();
        int res = coin_change_permutation(coins, sumRequired);
        System.out.println(res);*/


        /*!! copy paste the above code(coin change permutation)*/
/*        int res = coin_change_combination(coins, sumRequired);
        System.out.println(res);*/



/*        int n = scan.nextInt();
        int [] runs = new int[n];
        for (int i =0; i< n; i++)
            runs[i] = scan.nextInt();
        int requiredRun = scan.nextInt();
        boolean bool = target_sum_subsets(runs, requiredRun);
        System.out.println(bool);*/


/*        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] maze = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                maze[i][j] = scan.nextInt();
            }
        }

        int res = gold_mine(maze);
        System.out.println(res);*/


        /*!!copy paste the above code(gold mine)*/
/*        int res = min_cost_in_maze_traversal(maze );
        System.out.println(res);*/


/*        int n = scan.nextInt();
        int[] jumps = new int[n];
        for (int i=0; i<n; i++)
            jumps[i] = scan.nextInt();
        Integer[] dp = new Integer[n+1];
        int res = min_jump_moves_to_reach_at_top(n, jumps, dp);
        System.out.println(res);*/


/*        int n = scan.nextInt();
        int[] jumps = new int[n];
        for (int i=0; i<n; i++)
            jumps[i] = scan.nextInt();
        int[] dp = new int[n+1];
        int res = climb_stairs_with_variable_jumps(n, jumps, dp);
        System.out.println(res);*/

        /*!!copy paste the above code(climb stairs with variable jump)*/
/*        int total = climb_stairs(n, dp);
        System.out.println(total);*/

/*        int n = scan.nextInt();
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        int fibn = nth_fibonacci(n, dp);
        System.out.println(fibn);*/
    }

/*
1. You are given a number n.
2. You are required to print the nth element of fibonnaci sequence.

Note -> Notice precisely how we have defined the fibonnaci sequence
0th element -> 0
1st element -> 1
*/

    public static int nth_fibonacci(int n, int[] dp) {
        if (n == 0)
            return 0;

        if (dp[n] == 0 && n != 0) {
            if (dp[n - 1] == 0)
                dp[n - 1] = nth_fibonacci(n - 1, dp);

            if (dp[n - 2] == 0)
                dp[n - 2] = nth_fibonacci(n - 2, dp);

            dp[n] = dp[n - 1] + dp[n - 2];
            return dp[n];
        } else return dp[n];

    }


/*
1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. In one move, you are allowed to climb👉🏻👉🏻▶🗯↪⏭➡🤜🏻🔥🔥 1, 2 or 3 stairs👈🏻👈🏻.
4. You are required to print the number of different paths via which you can climb to the top.
*/
    public static int climb_stairs(int n, int[] dp) {
        if (n < 0) return 0;

        if (dp[n] != 0) return dp[n];

        if (n == 0)
            dp[0] = 1;
        else if (n == 1) {
            dp[1] = climb_stairs(0, dp);
        } else if (n == 2) {
            dp[2] = climb_stairs(1, dp) + climb_stairs(0, dp); // paths upto 0(jump from 0) + paths upto 1(jump from 1)
        } else if (n > 2)
            dp[n] = climb_stairs(n - 1, dp) + climb_stairs(n - 2, dp) + climb_stairs(n - 3, dp);

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
        for (int step = 0; step <= n - 1; step++) {
            for (int i = 1; i <= jumps[step] && step + i <= n; i++) {
                dp[step + i] += dp[step];
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
        for (int step = 0; step <= n - 1; step++) {
            for (int i = 1; i <= jumps[step] && dp[step] != null && step + i <= n; i++) {
                if (dp[step + i] != null && step != 0) {
                    dp[step + i] = Math.min(dp[step + i], 1 + dp[step]);
                } else if (dp[step + i] != null && step == 0) {
                    dp[step + i] = Math.min(dp[step + i], dp[step]);
                } else if (step == 0) { // && dp[step + i] == null
                    dp[step + i] = dp[step]; // 1
                } else dp[step + i] = 1 + dp[step]; // && dp[step + i] == null
            }
        }
        return dp[n];
    }


    public static void intFill(int[] array, int value) {
        int len = array.length;
        if (len > 0)
            array[0] = value;
        for (int i = 1; i < len; i += i)
            System.arraycopy(array, 0, array, i,
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
        int[][] dp = new int[maze.length][maze[0].length];

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (i == dp.length - 1 && j == dp[0].length - 1) { // bottom-right corner
                    dp[i][j] = maze[i][j];
                } else if (i == dp.length - 1) { // bottom-most row
                    dp[i][j] = dp[i][j + 1] + maze[i][j];
                } else if (j == dp[0].length - 1) { // right-most col
                    dp[i][j] = dp[i + 1][j] + maze[i][j];
                } else { // rest section out of above three
                    int min = Math.min(dp[i][j + 1], dp[i + 1][j]);
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

        for (int j = c - 1; j >= 0; j--) {
            for (int i = 0; i < r; i++) {
                if (j == c - 1) {
                    dp[i][j] = maze[i][j];
                } else if (i == 0) {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j + 1]) + maze[i][j];
                } else if (i == r - 1) {
                    dp[i][j] = Math.max(dp[i - 1][j + 1], dp[i][j + 1]) + maze[i][j];
                } else {
                    dp[i][j] = Math.max(Math.max(dp[i - 1][j + 1], dp[i][j + 1]), dp[i + 1][j + 1]) + maze[i][j];
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

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j != 0)
                    dp[i][j] = false;
                else if (j == 0) //dp[0][0] will be true
                    dp[i][j] = true;
                else {
                    int run = runs[i - 1]; // dp.length = runs.length+1
                    if (j == run && i != 0)
                        dp[i][j] = true;
                    else if (dp[i - 1][j])
                        dp[i][j] = true;
                    else if (j - run >= 0 && dp[i - 1][j - run] == true)
                        dp[i][j] = true;
                    else dp[i][j] = false;
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
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
        int[] dp = new int[sum + 1];
        dp[0] = 1; // 1 way of making sum=0 is that not to include anyone
        for (int coin : coins) { // let coins : 2,3,5 then this loop will be serial-wise from 2,3 to  5
            for (int j = coin; j <= sum; j++) {
                dp[j] += dp[j - coin];
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
        for (int i = 1; i <= sum; i++) {
            for (var coin : coins) {
                if (i < coin) continue;
                dp[i] += dp[i - coin];
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
                if (i == 0 || j == 0)
                    dp[i][j] = 0;

                else {
                    if (j >= thingWeigh[i - 1]) {
                        int max = Math.max(dp[i - 1][j], thingVal[i - 1] + dp[i - 1][j - thingWeigh[i - 1]]); // first parameter: thing(j-1) willn't do batting, 2nd parameter: thing(j-1) will do batting
                        dp[i][j] = max;
                    } else
                        dp[i][j] = dp[i - 1][j]; // thing(j-1) will not do batting, as he hasn't sufficient balls left to play, and he play only given num. of balls if he plays
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
    public static double fractional_knapsack(int capacity, int[] weigh, int[] value) {
        Item[] items = new Item[weigh.length];

        for (int i = 0; i < weigh.length; i++) {
            items[i] = new Item(weigh[i], value[i], i);
        }

        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item i1, Item i2) {
                if (i1.cost.compareTo(i2.cost) < 0) { // cost i1 < cost i2
                    return 1; // ascending
                } else if (i1.cost.compareTo(i2.cost) > 0) {
                    return -1; // descending
                } else return 0;
            }
        });

        double totalVal = 0;
        for (var item : items) { // items are sorted by per unit cost
            int curWeigh = (int) item.weight;
            int curVal = (int) item.value;

            if (capacity <= 0) break;

            if (capacity - curWeigh > 0) {
                capacity = capacity - curWeigh;
                totalVal += curVal;
            } else {
                double fraction = (double) capacity / curWeigh;
                double val = fraction * curVal;
                capacity = (int) (capacity - fraction * curWeigh);
//                break;
                totalVal += val;
            }
        }

        return totalVal;
    }

    public static int count_binary_strings_of_length(int n) { // no consecutive '0'
        int[][] dp = new int[2][n + 1]; // 2 :: 0,1 binary
        dp[0][0] = 0; //
        dp[1][0] = 0;
        dp[0][1] = 1;
        dp[1][1] = 1;

        for (int j = 2; j <= n; j++) {
            for (int i = 0; i <= 1; i++) {
                if (i == 0) {
                    dp[0][j] = dp[1][j - 1]; // :: '0' can come only after '1'
                } else { // i = 1
                    dp[1][j] = dp[0][j - 1] + dp[1][j - 1]; // :: '1' can come after '0' & '1' both
                }
            }
        }

        return dp[0][n] + dp[1][n];
    }

// :: :: :: :: :: :: :: :: :: :: :: :: :: :: :: :: :: :: :: :: :: :: :: :: :: :: :: ::
//1. You are given a number n.
//2. You are required to print the number of binary strings of length n with no consecutive 0's.

    public static long arrange_buildings(int totalPlots) { // on two sides of road
        int total_combination_on_1_side_of_road = count_binary_strings_of_length(totalPlots);
        int n = total_combination_on_1_side_of_road;
        // nC1 x nC1 :: total combinations for system
        long result = (long) n * n;
        return result;
    }

    public static int count_encodings(String numericStr) {
        int len = numericStr.length();
        int[] dp = new int[len];
        dp[0] = 1;
        if (len == 1) return dp[0];

        // for i==1
        if (numericStr.charAt(1) == '0') {
            if (numericStr.charAt(0) == '1' || numericStr.charAt(0) == '2')
                dp[1] = dp[0]; // dp[0]=1 // possible str~> 10 or 20 :: alpha are from 1 to 26(max)
            else dp[1] = 0;
        } else {
            // numericStr.charAt(i-1) != '0' && numericStr.charAt(i) != '0'
            if (Integer.parseInt(numericStr.substring(0, 2)) <= 26)
                dp[1] = 1 + 1; // 1 + dp[0] // ex:- 23 give ".." + 2(b), 23(w) :: 2 possibility
            else
                dp[1] = 1; // ex:- 93 {_9+3} give ".." + 3(c)
        }

        // from i=2
        for (int i = 2; i < len; i++) {
            if (numericStr.charAt(i) == '0') {
                if (numericStr.charAt(i - 1) == '0')
                    dp[i] = 0; // last 2 char places- 0,0 :: no combination : for 0,0 && 00
                else if (numericStr.charAt(i - 1) == '1' || numericStr.charAt(i - 1) == '2')
                    dp[i] = dp[i - 2]; // combination: 10, 20
                else dp[i] = 0; // no char for place -30 or >=27
            } else if (numericStr.charAt(i - 1) == '0') // numericStr.charAt(i) != '0' :: 0,0 combination is included in above condition statement
                dp[i] = dp[i - 1];
            else {
                // numericStr.charAt(i-1) != '0' && numericStr.charAt(i) != '0'
                if (Integer.parseInt(numericStr.substring(i - 1, i + 1)) <= 26)
                    dp[i] = dp[i - 1] + dp[i - 2];
                else
                    dp[i] = dp[i - 1];
            }
        }

        return dp[len - 1];
    }


//    1. You are given a string str of digits. (will never start with a 0)
//2. You are required to encode the str as per following rules
//    1 -> a
//    2 -> b
//    3 -> c
//    ..
//    25 -> y
//    26 -> z
//3. You are required to calculate and print the count of encodings for the string str.
//
//     For 123 -> there are 3 encodings. abc, aw, lc
//     For 993 -> there is 1 encoding. iic
//     For 013 -> This is an invalid input. A string starting with 0 will not be passed.
//     For 103 -> there is 1 encoding. jc
//     For 303 -> there are 0 encodings. But such a string maybe passed. In this case
//     print 0.
//Input Format
//A string str
//Output Format
//count of encodings

    public static int count_aPlus_bPlus_cPlus_subsequences(String str) {
//        count subsequences of type { a+ b+ c+ } // one or more 'a' + one or more 'b' + one or more 'c'

        int aType/*count of a+ Type string*/ = 0; // a+ Type string ==> there is no 'b' v 'c' prior to 'a' & same after 'a'
        int abType/*count of a+b+ Type string*/ = 0;
        int abcType/*count of a+b+c+ Type string*/ = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == 'a')
                aType = 2 * aType + 1; // aType(append to prev a's) + aType(not appended) + 1(start new subsequence)
            else if (ch == 'b')
                abType = abType /* append to its prior a+b+ type string */ + abType/* not append after its prior a+b+ */ + aType/*append to prior a+ Type string */;
            else if (ch == 'c')
                abcType = abcType/*append to prior a+b+c+ Type sting*/ + abcType/*not append to prior a+b+c+ Type string*/ + abType/*append to prior a+b+ Type string*/;
        }

        return abcType;
    }

//    1. You are given a string str.
//2. You are required to calculate and print the count of subsequences of the nature a+b+c+.
//For abbc -> there are 3 subsequences. abc, abc, abbc
//For abcabc -> there are 7 subsequences. abc, abc, abbc, aabc, abcc, abc, abc.
//    Input Format
//A string str
//Output Format
//count of subsequences of the nature a+b+c+

    //greedy question
    public static int maximum_sum_non_adjacent_element_selection(int[] a) {
        // restriction is on include ==> item at ith pos must include only if the previous item is not included in prior selection
        // there is no restriction on exclude item

        int include/*initialised by 1st item of a[]*/ = a[0];
        int exclude/*neutral initialisation*/ = 0;

        for (int i = 1; i < a.length; i++) {
            int newInclude = a[i]/*current item*/ + exclude/*answer upto last step of exclusion*/;
            int newExclude = Math.max(include/*exclude after inclusion of prior item*/, exclude/*exclude after exclusion of prior item*/);

            include/*updating for the next step*/ = newInclude;
            exclude/*updating for the next step*/ = newExclude;
        }

        int ans = Math.max(include, exclude);
        return ans;
    }

    public static long paint_houses(int n/*no. of houses*/, int[][] arr/*contain 'n' houses with 3 colors{red, blue, green}*/) {
        long totalCostWith_LastHouseColor_RED = arr[0][0];
        long totalCostWith_LastHouseColor_BLUE = arr[0][1];
        long totalCostWith_LastHouseColor_GREEN = arr[0][2];

        for (int i = 1; i < n; i++) {
            long newTotalCostWith_LastHouseColor_RED = arr[i/*house id*/][0/*red*/]/*cost of red coloring for this house*/ + Math.min(totalCostWith_LastHouseColor_BLUE, totalCostWith_LastHouseColor_GREEN)/*Including red color ==> only after prior blue/green(excluded red)*/; // given in question that same color on consecutive houses not allowed
            long newTotalCostWith_LastHouseColor_BLUE = arr[i][1/*blue*/] + Math.min(totalCostWith_LastHouseColor_RED, totalCostWith_LastHouseColor_GREEN);
            long newTotalCostWith_LastHouseColor_GREEN = arr[i][2/*green*/] + Math.min(totalCostWith_LastHouseColor_RED, totalCostWith_LastHouseColor_BLUE);

            totalCostWith_LastHouseColor_RED/*updating the cost on coloring(red,blue,green) with last house' color red */ = newTotalCostWith_LastHouseColor_RED;
            totalCostWith_LastHouseColor_BLUE/*"" last house' color blue*/ = newTotalCostWith_LastHouseColor_BLUE;
            totalCostWith_LastHouseColor_GREEN/*"" last house' color green*/ = newTotalCostWith_LastHouseColor_GREEN;
        }

        long ans = Math.min(totalCostWith_LastHouseColor_RED, Math.min(totalCostWith_LastHouseColor_BLUE, totalCostWith_LastHouseColor_GREEN));
        return ans;
    }


//1. You are given a number n and a number k separated by a space, representing the number of houses and number of colors.
//2. In the next n rows, you are given k space separated numbers representing the cost of painting nth house with one of the k colors.
//3. You are required to calculate and print the minimum cost of painting all houses without painting any consecutive house with same color.
//Input Format
//A number n
//n1-0th n1-1st n1-2nd .. n1-kth
//n2-0th n2-1st n2-2nd .. n2-kth
//.. n number of elements
//Output Format
//A number representing the minimum cost of painting all houses without painting any consecutive house with same color.


    public static long paint_houses_many_colors( int[/*no. of houses*/][/*cost of jth colors for a house*/] arr/*contain 'n' houses with k colors*/) {
        int n/*no. of houses*/ = arr.length/*total rows*/;
        int c/*no. of colors*/ = arr[0].length/*total cols*/;

        int[][] dp = new int[n/*no. of rows{houses}*/][c/*no. of columns{colors}*/];


        int least = Integer.MAX_VALUE;
        int secondLeast = Integer.MAX_VALUE;

        for (int j = 0; j < c; j++) {
            dp[0][j]/*cost of coloring 0th house with jth color*/ = arr[0][j];

            if (dp[0][j] <= least) {/* To store the minimum & second min color' cost for 0th row(house)*/
                secondLeast = least;
                least = dp[0][j];
            }
            else if (dp[0][j] <= secondLeast)
                secondLeast = dp[0][j];
        }

        for (int i = 1; i < n; i++) {
            int newLeast = Integer.MAX_VALUE;
            int newSecondLeast = Integer.MAX_VALUE;
            for (int j = 0; j < c; j++) {

                if (least == dp[i-1][j])
                    dp[i][j] = arr[i][j] + secondLeast; // we can't choose this jth color
                else
                    dp[i][j] = arr[i][j] + least;


                if (dp[i][j] <= newLeast) {/* To store the minimum & second min color' cost for 0th row(house)*/
                    newSecondLeast = newLeast;
                    newLeast = dp[i][j];
                }
                else if (dp[i][j] <= newSecondLeast)
                    newSecondLeast = dp[i][j];

                /* O(n^3) Solution Approach*/
//                int min = Integer.MAX_VALUE;
//                for (int jPrior = 0; jPrior < c; jPrior++) {
//                    if (jPrior != j && dp[i-1][jPrior]/*min cost till the (i-1)th house dp[][] @ (i-1)th house color != jth color*/ < min){
//                        min = dp[i-1][jPrior];
//                    }
//                }
//                dp[i][j]/*cost min till ith house + ith house with jth color*/ = arr[i][j]/*cost of coloring with jth color*/ + min/*min cost upto (i-1)th house coloring @ color ith house with jth color*/;
            }
            least = newLeast;
            secondLeast = newSecondLeast;
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < c; j++) {
            if (dp[n-1][j] < min)
                min = dp[n-1][j];
        }
        return min;
    }


    public static void paint_fence() {

        Scanner scan = new Scanner(System.in);
        int n/*no. of houses*/ = scan.nextInt();
        int k/*no. of colors*/ = scan.nextInt();

        int[][] dp = new int[2/*last two colors of ii type(same) & ij type(different)*/][n];

        dp[0][1]/*same color 0th, 1th house*/ = k;// P&C question
        dp[1][1]/*different color "" ""*/ = k/*kC1*/*(k-1)/*(k-1)C1*/; //P&C Question

        for(int j=2; j<n; j++) {
            dp[0/*same color*/][j/*current house*/] = dp[1/*different*/][j-1/*prior house*/];

            dp[1][j] = dp[0][j-1]*(k-1)/*there are k-1 different color to prior house color*/
                    + dp[1][j-1]*(k-1);

        }

        System.out.println(dp[0][n-1] + dp[1][n-1]);
    }

    public static void tiling_with_2X1_tiles() {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] dp = new int[n+1];
        dp[1]/*to fill 2x1 floor with 2x1 tile*/ = 1;
        dp[2]/*ways to fill 2x2 floor with 2x1 tile(can rotate)*/ = 2;

        for(int i=3; i<=n; i++)
            dp[i] = dp[i-1]/*vertically placed 2x1 and 2x(n-1) floor area left*/ + dp[i-2]*1/*horizontal placed 2x1 tile, now remaining - to fill 2x(n-2) + 2x1 (AND operation) because both are required to meet the expectation*/;

        System.out.println(dp[n]);
    }


    public static void tiling_with_MX1_tiles() {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        int [] dp = new int[n+1];
        for(int j=1; j<m && j<=n; j++) {
            dp[j] = 1;
        }
        if(m<=n) dp[m] = 2;

        for(int j = m+1; j<=n; j++) {
            dp[j] = dp[j-1]/*one tile is placed vertical*/ + dp[j-m]/*when tile mx1 placed horizontal
            other m-1 tiles have to placed up horizontal and + dp[j-m]*/;
        }
        System.out.println(dp[n]);
    }


    public static void friends_pairing() {
        Scanner scan = new Scanner(System.in);
        int n/*friends*/ = scan.nextInt();
        int[] dp = new int[n+1];
        dp[0]/*for 0 people :- no combination possible*/ = 0;
        dp[1] = 1;
        dp[2] = 2;/*both single | both paired with each other*/

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1]/*ith is single, reduced to friends pairing of i-1 people*/ + dp[i-2]/*ith pair with a friend, reduced to friend pairing of i-2 people*/ * (i-1)/*(n-1)C1 :- select a friend for pairing*/;
        }

        System.out.println(dp[n]);
    }


    public static void partition_into_subsets() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();

        int[][] dp = new int[k+1/*no. of rows*/][n+1/*no. of cols*/];

        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0/*team of member 0==> 0*/ || j == 0/*for 0 people there is no team possible*/)
                    dp[i][j] = 0;
                else if (i == 1/*1 team formation*/)
                    dp[i][j] = 1;//all people in one team/*one possible way*/
                else if (i/*no. of team*/ > j/*no. of people*/)
                    dp[i][j] = 0;
                else if (i==j/*no. of team == no. of people==> each team with 1 member each(empty subset not allowed)*/)
                    dp[i][j] = 1;
                else {
                    // for ith person
                    /*he asks if 'i' teams are formed by prior persons*/
                    dp[i][j] += dp[i/*teams*/][j-1] * i/* iC1 :- he selects 1 team out of i teams to co-participate*/;
                    /*he asks if 'i-1' teams are formed by prior persons*/ // then he can full i teams
                    dp[i][j] += dp[i-1/*'i-1' teams*/][j-1/*'j-1' persons*/]; // he participate as single(in team)
                }
            }
        }

        System.out.println(dp[k][n]);

    }


    public static void buy_n_sell_stocks_1_transaction_allowed() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = scan.nextInt();
        }

        int lowestPriceSoFar = Integer.MAX_VALUE;
        int maxProfit = 0;
        int profitIfSoldToday = 0;

        for(int i=0; i < prices.length; i++) {
            if (prices[i] < lowestPriceSoFar)
                lowestPriceSoFar = prices[i];

            profitIfSoldToday = prices[i] - lowestPriceSoFar;
            if (maxProfit < profitIfSoldToday)
                maxProfit = profitIfSoldToday;
        }
        System.out.println(maxProfit);
    }


    public static void buy_n_sell_stocks_Infinite_transaction_allowed() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scan.nextInt();
        }

        int buyingDate = 0;
        int sellingDate = 0;
        int profit = 0;

        for (int i = 1; i < n; i++) {
            if (prices[i] >= prices[i-1])
                sellingDate++;
            else {
                profit += prices[sellingDate] - prices[buyingDate];
                buyingDate = sellingDate = i;
            }
        }

        profit += prices[sellingDate] - prices[buyingDate];
        System.out.println(profit);
    }


//    public static void buy_n_sell_stocks_with_Transaction_Fee_Infinite_transaction_allowed() {
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        int[] prices = new int[n];
//        for (int i = 0; i < n; i++) {
//            prices[i] = scan.nextInt();
//        }
//
//        int barrier = scan.nextInt(); // transaction fee
//
//        int buyingDate = 0;
//        int sellingDate = 0;
//        int profit = 0;
//
//        for (int i = 1; i < n; i++) {
//            if (prices[i] >= prices[i-1])
//                sellingDate++;
//            else {
//                if (prices[sellingDate] - prices[buyingDate] > barrier)
//                    profit += prices[sellingDate] - prices[buyingDate] - barrier;
//
//                buyingDate = sellingDate = i;
//            }
//        }
//
//        if (prices[sellingDate] - prices[buyingDate] > barrier)
//            profit += prices[sellingDate] - prices[buyingDate] - barrier;
//
//        System.out.println(profit);
//    }


    public static void buy_n_sell_stocks_with_Transaction_Fee_Infinite_transaction_allowed() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scan.nextInt();
        }

        int fee = scan.nextInt();

        int oldBoughtStateProfit = -prices[0]/*minus indicates loan*/; //bought the first share'
        int oldSoldStateProfit = 0; // no chance to sell on first day

        for (int i = 1; i < n; i++) {
            int newBoughtStateProfit = 0;
            int newSoldStateProfit = 0;

            if (oldSoldStateProfit -prices[i] /*no fee on buying share'*/ /*today share' bought on old sold profit*/ > oldBoughtStateProfit)
                newBoughtStateProfit = oldSoldStateProfit -prices[i];
            else
                newBoughtStateProfit = oldBoughtStateProfit;

            // sell share' section
            if (oldBoughtStateProfit + prices[i] -fee > oldSoldStateProfit)
                newSoldStateProfit = oldBoughtStateProfit + prices[i] - fee;
            else
                newSoldStateProfit = oldSoldStateProfit;

            oldBoughtStateProfit = newBoughtStateProfit;
            oldSoldStateProfit = newSoldStateProfit;
        }

        System.out.println(oldSoldStateProfit); //
    }


    /*public static void buy_n_sell_stocks_with_cooldown__Infinite_transaction_allowed() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scan.nextInt();
        }

        int buyingDate = 0;
        int sellingDate = 0;
        int profit = 0;

        for (int i = 1; i < n; i++) {
            if (prices[i] >= prices[i-1])
                sellingDate++;
            else {
                profit += prices[sellingDate] - prices[buyingDate];
                i++;
                buyingDate = sellingDate = i;
            }
        }

        profit += prices[sellingDate] - prices[buyingDate];
        System.out.println(profit);

    }*/

    public static void buy_n_sell_stocks_with_cooldown__Infinite_transaction_allowed() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scan.nextInt();
        }

        int oldBoughtStateProfit = -prices[0]; //bought the first share'
        int oldSoldStateProfit = 0; // no chance to sell on first day
        int oldCooledStateProfit = 0; // cooldown(gap) come after the selling item

        for (int i = 1; i < n; i++) {
            int newBoughtStateProfit = 0;
            int newSoldStateProfit = 0;
            int newCooledStateProfit = 0;

            if (oldCooledStateProfit - prices[i] > oldBoughtStateProfit) {
                newBoughtStateProfit = oldCooledStateProfit - prices[i];
            }
            else newBoughtStateProfit = oldBoughtStateProfit;

            if (oldBoughtStateProfit + prices[i] > oldSoldStateProfit)
                newSoldStateProfit = oldBoughtStateProfit + prices[i];
            else newSoldStateProfit = oldSoldStateProfit;

            if (oldSoldStateProfit > oldCooledStateProfit)
                newCooledStateProfit = oldSoldStateProfit;
            else newCooledStateProfit = oldCooledStateProfit;

            oldBoughtStateProfit = newBoughtStateProfit;
            oldSoldStateProfit = newSoldStateProfit;
            oldCooledStateProfit = newCooledStateProfit;
        }

        System.out.println(Math.max(oldSoldStateProfit, oldCooledStateProfit));
    }


    public static void best_time_to_buy_n_sell_stocks_Two_transaction_allowed() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scan.nextInt();
        }

        int maxProIfSoldToday/*maximum profit if sold today*/ = 0;
        int leastSoFar/*least stock price so far*/ = prices[0];
        int[] dpLeft/*max profit sold upto today*/ = new int[n];

        for (int i = 1; i < n; i++) {
            if (prices[i] < leastSoFar)
                leastSoFar = prices[i];

            maxProIfSoldToday = prices[i] - leastSoFar;

            if (maxProIfSoldToday > dpLeft[i-1])
                dpLeft[i] = maxProIfSoldToday;
            else dpLeft[i] = dpLeft[i-1];
        }

        int maxProIfBuyToday = 0;
        int maxPriceFromTodayOn/*transaction profit-- transaction happen on (buy + sell)*/ = prices[n-1];
        int[] dpRight/*max profit on transaction if buy today or after today*/ = new int[n];

        for (int i = n-2; i >= 0; i--) {
            if (prices[i] > maxPriceFromTodayOn)
                maxPriceFromTodayOn = prices[i];

            maxProIfBuyToday = maxPriceFromTodayOn - prices[i];

            if (maxProIfBuyToday > dpRight[i+1])
                dpRight[i] = maxProIfBuyToday;
            else dpRight[i] = dpRight[i+1];
        }

        int maxProfit/*dpLeft + dpRight (2 top max transaction required)*/ = 0;
        for (int i = 0; i < n; i++) {
            int profit_i_2Trans = dpLeft[i]/*dpLeft[i] -> max profit on transaction upto i'th day*/ + dpRight[i]/*dpRight[i] -> max profit on transaction from i'th day*/;
            if (maxProfit < profit_i_2Trans)
                maxProfit = profit_i_2Trans;
        }

        System.out.println(maxProfit);
    }


    public static void best_time_to_buy_n_sell_stocks_Max_k_transaction_allowed() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scan.nextInt();
        }

        int k/*no. of transaction allowed*/ = scan.nextInt();

        int[][] dp = new int[k+1][n];

        for (int i/*max Transactions*/ = 0; i <= k; i++) {
            for (int j/*Day number*/ = 0; j < n; j++) {
                if (i==0/*max transactions 0==>no buy no sell*/ || j==0/*on first day transactions==>'__no transaction',b0s0//buy on 0th day & sell on 0th day,b0s0b0s0, b0s0b0s0b0s0*/)
                    dp[i][j] = 0;

                int max = 0;
                if (j!=0)
                    max = dp[i][j-1]; // k transaction under j-1 days

                for (int d=j-1; d>=0 && i>0/*day must not be first day*/; d--)  // max from {all day's}(j-1 transactions + Transaction->Buy(d'th day),Sell(j'th day)
                    max = Math.max(max, dp[i-1][d] + prices[j]-prices[d]);

                dp[i][j] = max;
            }
        }

        System.out.println(dp[k][n-1]);
    }

    // to tie the properties of items
    static class Item {
        Double cost;
        double weight, value, index;

        public Item(int weight, int value, int index) {
            this.index = index; // int -> double :: auto
            this.weight = weight;
            this.value = value;
            cost = this.value / this.weight; // double -> Double :: auto
        }
    }
}

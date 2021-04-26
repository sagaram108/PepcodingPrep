package practice.Recursion_and_BackTracking;

public class Recursion_in_Array {
    public static void main(String[] args) {
        int [] a = all_indices(new int[] {2,1,4,3,2,3,7,0,2}, 2, 0, 0);
        for (var i : a) System.out.print(i + " ");
    }


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//1. You are given a number n, representing the size of array a.
//2. You are given n numbers, representing elements of array a.
//3. You are required to print the elements of array from beginning to end each in a separate line.
//4. For the above purpose complete the body of displayArr function. Don't change the signature.

    public static void display_Array(int[] arr, int idx){
        if(arr.length == 0 || idx >= arr.length) return;

        System.out.println(arr[idx]);
        display_Array(arr, idx+1);
    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//1. You are given a number n, representing the count of elements.
//2. You are given n numbers.
//3. You are required to find the maximum of input.
//4. For the purpose complete the body of maxOfArray function. Don't change the signature.

    public static int max_Of_Array(int[] arr, int idx){
        if (idx >= arr.length) return Integer.MIN_VALUE;

        int max = Math.max(arr[idx], max_Of_Array(arr, idx+1));
        return max;
    }


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//1. You are given a number n, representing the count of elements.
//2. You are given n numbers.
//3. You are given a number x.
//4. You are required to find the first index at which x occurs in array a.
//5. If x exists in array, print the first index where it is found otherwise print -1.

    public static int first_Index(int[] arr, int idx, int x){

        if (idx >= arr.length) return -1;

        if (arr[idx] == x) return idx;
        else return first_Index(arr, idx+1, x);
    }



//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//1. You are given a number n, representing the count of elements.
//2. You are given n numbers.
//3. You are given a number x.
//4. You are required to find the all indices at which x occurs in array a.
//5. Return an array of appropriate size which contains all indices at which x occurs in array a.

//    fsf ⇒ found so far ॥ x-found how many times so far
    public static int[] all_indices(int[] arr, int x, int idx, int fsf) {
//        base case
        if (idx == arr.length) {
            int[] a = new int[fsf];
            return a;
        }

        if (arr[idx] == x) {
            fsf ++;
        }

        int[] res = all_indices(arr, x, idx+1, fsf);
        if (fsf > 0)
            res[fsf-1] = idx; // for position of last-matched element
        return res;
    }

//    public static int[] all_Indices(int[] arr, int x, int idx, int fsf) {
//        // write ur code here
//
//        List<Integer> list = new ArrayList<>();
//        add_To_List(arr, x, idx, list);
//        return list.stream().mapToInt((Integer i) -> i).toArray();
//    }
//
//    private static void add_To_List(int[] arr, int x, int idx, List<Integer> list) {
//        if (idx >= arr.length) return;
//        if (arr[idx] == x) list.add(idx);
//
//        add_To_List(arr, x, idx+1, list);
//    }
}

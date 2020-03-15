package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given a sorted and rotated array A of N distinct elements which is rotated at some point, and given an element K. The task is to find the index of the
 * given element K in the array A.
 *
 * Input:
 * The first line of the input contains an integer T, denoting the total number of test cases. Then T test cases follow.
 * Each test case consists of three lines. First line of each test case contains an integer N denoting the size of the given array.
 * Second line of each test case contains N space separated integers denoting the elements of the array A. Third line of each test case contains an integer K
 * denoting the element to be searched in the array.
 *
 * Output:
 * Corresponding to each test case, output the index of the element found in the array.  If element is not present, then output -1.
 *
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ N ≤ 107
 * 0 ≤ Ai ≤ 108
 * 1 ≤ K ≤ 108
 *
 * Example:
 * Input:
 * 3
 * 9
 * 5 6 7 8 9 10 1 2 3
 * 10
 * 3
 * 3 1 2
 * 1
 * 4
 * 3 5 1 2
 * 6
 *
 * Output:
 * 5
 * 1
 * -1
 *
 * Explanation:
 * Testcase 1: 10 is found at index 5.
 */


public class SearchInRotatedArray {

    static int advanceBinarySearch(int []arr, int start, int end, int key) {

        if (start > end)
            return -1;

        int mid = (start + end)/2;
        if (arr[mid] == key)
            return mid;

        if (arr[start] <= arr[mid]) {
            if (key >= arr[start] && key <= arr[mid])
                return advanceBinarySearch(arr, start, mid-1, key);

            return advanceBinarySearch(arr, mid+1, end, key);
        }

        if (key >= arr[mid] && key <= arr[end])
            return advanceBinarySearch(arr, mid+1, end, key);

        return advanceBinarySearch(arr, start, mid-1, key);
    }

    public static void main(String []args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        while (t-- >0) {
            int n = Integer.parseInt(reader.readLine());
            int []arr = new int[n];
            String []input = reader.readLine().split(" ");
            int key = Integer.parseInt(reader.readLine());

            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            int index = advanceBinarySearch(arr, 0, n-1, key);
            System.out.println(index);
        }
    }
}

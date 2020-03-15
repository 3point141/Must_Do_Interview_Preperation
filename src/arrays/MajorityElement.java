package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Given an array A of N elements. Find the majority element in the array. A majority element in an array A of size N is an element that appears more than N/2 times in the array.
 *
 * Input:
 * The first line of the input contains T denoting the number of testcases. The first line of the test case will be the size of array and second line will be the elements of the array.
 *
 * Output:
 * For each test case the output will be the majority element of the array. Output "-1" if no majority element is there in the array.
 *
 * Constraints:
 * 1 <= T<= 100
 * 1 <= N <= 107
 * 0 <= Ai <= 106
 *
 * Example:
 * Input:
 * 2
 * 5
 * 3 1 3 3 2
 * 3
 * 1 2 3
 *
 * Output:
 * 3
 * -1
 *
 * Explanation:
 * Testcase 1: Since, 3 is present more than N/2 times, so it is the majority element.
 */

public class MajorityElement {

    static int findCandidate( int []arr, int size) {
        int majority_index = 0, count = 1;
        for(int i = 1; i<size; i++) {
            if (arr[i] == arr[majority_index]) {
                count ++;
            } else {
                count --;
            }

            if(count == 0) {
                majority_index = i;
                count = 1;
            }
        }
        return arr[majority_index];
    }

    static boolean isMajority(int []arr, int candidate, int size) {
        int count = 0;
        for(int i=0; i<size; i++) {
            if(arr[i] == candidate) {
                count ++;
            }

            if(count > size/2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String []args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            int []input = new int[n];
            String []array = reader.readLine().split(" ");
            for(int i=0; i<n; i++) {
                input[i] = Integer.parseInt(array[i]);
            }

            //Applying Moore's Voting Algorithm
            int candidate = findCandidate(input, n);
            if (isMajority(input, candidate, n)) {
                System.out.println(candidate);
            } else {
                System.out.println(-1);
            }
        }
    }
}

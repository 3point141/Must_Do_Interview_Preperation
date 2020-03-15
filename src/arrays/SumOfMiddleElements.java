package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given 2 sorted arrays A and B of size N each. Print sum of middle elements of the array obtained after merging the given arrays.
 *
 * Input:
 * The first line contains T denoting the number of testcases. Then follows description of testcases.
 * Each case begins with a single positive integer N denoting the size of array. The second line contains the N space separated positive integers denoting the elements of array A. The third line contains N space separated positive integers denoting the elements of array B.
 *
 * Output:
 * For each testcase, print the sum of middle elements of two sorted arrays. The number of the elements in the merged array are even so there will be 2 numbers in the center n/2 and n/2 +1. You have to print their sum.
 *
 * Constraints:
 * 1 <= T <= 50
 * 1 <= N <= 103
 * 1 <= A[i] <= 106
 * 1 <= B[i] <= 106
 *
 * Example:
 * Input :
 * 1
 * 5
 * 1 2 4 6 10
 * 4 5 6 9 12
 *
 * Output :
 * 11
 *
 * Explanation:
 * Testcase 1: After merging two arrays, sum of middle elements is 11 (5 + 6).
 */

public class SumOfMiddleElements {

    static int[] merge(int []arrayA, int []arrayB, int size) {
        int []result = new int[size*2];
        int index = 0;

        for(int i=0, j=0; i<size && j<size;) {
            if(arrayA[i] <= arrayB[j]) {
                result[index] = arrayA[i];
                index++;
                i++;
            } else {
                result[index] = arrayB[j];
                index++;
                j++;
            }

            if(i==size){
                for(int k = j; k<size; k++)
                    result[index] = arrayB[k];
            }

            if(j==size) {
                for(int k = j; k<size; k++)
                    result[index] = arrayA[k];
            }
        }
        return result;
    }

    public static void main(String []args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine());

            int []arrA = new int[n];
            int []arrB = new int[n];

            String []input1 = reader.readLine().split(" ");
            String []input2 = reader.readLine().split(" ");

            for(int i=0; i<n ;i++) {
                arrA[i] = Integer.parseInt(input1[i]);
                arrB[i] = Integer.parseInt(input2[i]);
            }

            //merge
            int []merged =  merge(arrA, arrB, n);
            System.out.println(merged[n-1] + merged[n]);
        }
    }
}

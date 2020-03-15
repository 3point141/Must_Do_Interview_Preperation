package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given an array of characters which is basically a sentence. However there is no space between different words and the first letter of every word is in uppercase.
 * You need to print this sentence after following amendments:
 * (i) Put a single space between these words
 * (ii) Convert the uppercase letters to lowercase.
 *
 * Input:
 * The first line of input contains the number of test cases. The description of T test case follows.
 * Each test case contains a single line containing a string.
 *
 * Output:
 * Print the desired Sentence.
 *
 * Constraints:
 * 1<=T<=30
 * 1<=Size of String <=100
 *
 * Example:
 *
 * Input :
 * 2
 * BruceWayneIsBatman
 * You
 *
 * Output :
 * bruce wayne is batman
 * you
 */

public class AmendTheSentence {

    static void amendTheSentence(char []str, int size) {
        if(str[0] < 97) {
            System.out.print((char)(str[0]+32));
        } else {
            System.out.print(str[0]);
        }
        for(int i=1; i<size; i++) {
            if(str[i] >= 97) {
                System.out.print(str[i]);
            } else {
                System.out.print(" "+(char)(str[i]+32));
            }
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            String input = reader.readLine();
            char str[] = input.toCharArray();
            amendTheSentence(str, input.length());
        }
    }
}

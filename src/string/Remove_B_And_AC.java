package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given a string, eliminate all “b” and “ac” in the string, replace them in-place and iterate over the string once.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows.
 * Each test case contains a string of length N.
 *
 * Output:
 * Print the resultant substring after removing 'b' and 'ac' from string.
 *
 * Constraints:
 * 1 ≤ T ≤ 200
 * 1 ≤ N ≤ 200
 *
 * Example:
 * Input:
 * 2
 * acbac
 * aababc
 *
 * Output:
 *
 * aaac
 */
public class Remove_B_And_AC {

    static String removeBAndAC(String s) {

        //uses pattern and matcher to replace all the substring occurrence
        s = s.replaceAll("ac","");
        s = s.replaceAll("b", "");
        return s;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            String input = reader.readLine();
            System.out.println(removeBAndAC(input));
        }
    }
}

package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Given a string which may contains lowercase and uppercase chracters. The task is to remove all  duplicate characters from the string and print the resultant string.  The order of remaining characters in the output should be same as in the original string.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. Each test case contains a string.
 *
 * Output:
 * Print the resultant string after removing duplicate characters from string.
 *
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ N ≤ 100
 *
 * Example:
 * Input:
 * 2
 * geeksforgeeks
 * HappyNewYear
 *
 * Output:
 * geksfor
 * HapyNewYr
 *
 * Explanation:
 * Testcase 1: After removing duplicate characters such as e, k, g, s, we have string as geksfor.
 */

public class RemoveAllDuplicates {

    static String removeDuplicate(String s) {
        List<Character> unique = new ArrayList<>();
        char []str = s.toCharArray();

        for( char character : str) {
            if(!unique.contains(character)) {
                unique.add(character);
            }
        }

        String result = "";
        for (Character c : unique) {
            result = result.concat(String.valueOf(c));
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        while (t-- > 0) {
            String input = reader.readLine();
            input = removeDuplicate(input);
            System.out.println(input);
        }
    }
}

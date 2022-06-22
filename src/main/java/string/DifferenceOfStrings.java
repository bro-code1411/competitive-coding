package string;

import java.util.HashSet;

/**
 * Given two strings string1 and string2, remove those characters from first string(string1) which are present in second string(string2). Both the strings are different and contain only lowercase characters.
 * NOTE: Size of  first string is always greater than the size of  second string( |string1| > |string2|).
 * <p>
 * Input:
 * string1 = "computer"
 * string2 = "cat"
 * Output = "ompuer"
 * Explanation: After removing characters(c, a, t)
 * from string1 we get "ompuer".
 */
public class DifferenceOfStrings {
    public static void main(String[] args) {
        String a = "geeksforgeeks";
        HashSet<String> b = new HashSet(){{
            add("a");
            add("geeks");
            add("for");
            add("sda");
            add("gee");
        }};
        boolean res = solve(a, b);
        System.out.println(res);
    }

    public static boolean solve(String a, HashSet<String> b) {
        boolean result = false;
        int j = 0;
        for (int i = 1; i + j <= a.length(); i++) {
            String sub = a.substring(j, i);
            if (b.contains(sub)) {
                if (i + j == a.length()) {
                    return true;
                }
                result = solve(a.substring(i + j), b);
            }
        }
        return result;
    }
}

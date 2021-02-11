package recursion;

import java.util.List;

/**
 * Tell if a string can be constructed by a given list of strings.
 * You can repeat, rearrange strings or not use some of them
 *
 * Sample Test Case:
 * List of string: "a","aba","c","d"
 * Create: cacaabaaba
 * Output: true
 */
public class Question1 {

    public boolean solve(List<String> a, String b) {
        boolean result = false;
        if (b.isEmpty()) {
            return true;
        }
        for (int i = 1; i <= b.length(); i++) {
            String sub = b.substring(0,i);
            if (a.contains(sub)) {
                result = solve(a, b.substring(i));
            }
        }
        return result;
    }
}


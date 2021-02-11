package recursion;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Question1Test {

    @Test
    public void testCase1() {
        Question1 question = new Question1();
        List<String> a = Arrays.asList("a","aba","c","d");
        String b = "cacaabaaba";
        assert (question.solve(a, b));
    }

    @Test
    public void testCase2() {
        Question1 question = new Question1();
        List<String> a = Arrays.asList("a","aba","c","d");
        String b = "cacaabaabadav";
        assert (!question.solve(a, b));
    }
    @Test
    public void testCase3() {
        Question1 question = new Question1();
        List<String> a = Arrays.asList("pqq","aba","c","d");
        String b = "pqraba";
        assert (!question.solve(a, b));
    }
}

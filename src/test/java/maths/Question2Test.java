package maths;

import org.junit.Test;

public class Question2Test {

    @Test
    public void testCase1() {
        Question2 question = new Question2();
        assert (question.solve(1, 2) == 3);
    }
}
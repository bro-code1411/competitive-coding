package maths;

import org.junit.Test;

public class MultiplyTest {

    @Test
    public void testCase1() {
        Multiply question = new Multiply();
        assert (question.solve(4, 2) == 8);
    }
}
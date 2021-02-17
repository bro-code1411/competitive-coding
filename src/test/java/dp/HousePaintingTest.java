package dp;

import org.junit.Test;

public class HousePaintingTest {

    @Test
    public void testCase1() {
        int[][] a = {{1, 2, 3}, {3, 4, 5}, {5, 3, 2}, {7, 8, 9}};
        HousePainting question = new HousePainting();
        System.out.println(question.solve(a, 4));
    }
}

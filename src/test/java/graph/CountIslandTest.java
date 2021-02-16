package graph;

import org.junit.Test;

public class CountIslandTest {
    @Test
    public void test1() {
        int m[][] = new int[][]{{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}};
        CountIsland question = new CountIsland();
        int row = 5, col = 5;
        assert (question.solve(m, row, col) == 5);
    }
}

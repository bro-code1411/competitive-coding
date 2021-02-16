package graph;

/**
 * Find the number of islands represented by 1
 */
public class CountIsland {
    public static void main(String[] args) {
        int m[][] = new int[][]{{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}};
        CountIsland question = new CountIsland();
        int row = 5, col = 5;
        System.out.println("Number of islands is: " + question.solve(m, row, col));
    }

    private int maxRow;
    private int maxCol;

    public int solve(int[][] m, int row, int col) {
        this.maxCol = col;
        this.maxRow = row;
        int count = 0;
        boolean[][] v = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (m[i][j] == 1 && !v[i][j]) {
                    dfs(m, i, j, v);
                    ++count;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] m, int i, int j, boolean[][] v) {
        v[i][j] = true;
        int r[] = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int c[] = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
        for (int k = 0; k < 8; k++) {
            if (canGo(m, i + r[k], j + c[k], v)) {
                dfs(m, i + r[k], j + c[k], v);
            }
        }
    }

    private boolean canGo(int[][] m, int i, int j, boolean[][] v) {
        return (i >= 0) && (i < this.maxRow) && (j >= 0) && (j < this.maxCol) && (m[i][j] == 1 && !v[i][j]);
    }

}

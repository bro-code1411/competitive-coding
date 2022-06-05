package graph;

public class MaximumEffortPath {
    public int minimumEffortPath(int[][] heights) {
        int l = 0;
        int r = 1000000;
        int res = r;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (dfsUtil(heights, mid)) {
                res = Math.min(res, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean dfsUtil(int[][] heights, int mid) {
        int row = heights.length;
        int col = heights[0].length;
        boolean visited[][] = new boolean[row][col];
        return canReachDest(0, 0, heights, visited, row, col, mid);
    }

    boolean canReachDest(int x, int y, int[][] arr,
                         boolean[][] vis, int row, int col, int mid) {
        if (x == row - 1 && y == col - 1) {
            return true;
        }
        vis[x][y] = true;
        for (int[] direction : directions) {
            int adjacentX = x + direction[0];
            int adjacentY = y + direction[1];
            if (isValid(adjacentX, adjacentY, row, col) && !vis[adjacentX][adjacentY]) {
                int diff = Math.abs(arr[adjacentX][adjacentY] - arr[x][y]);
                if (diff <= mid) {
                    if (canReachDest(adjacentX, adjacentY, arr, vis, row, col, mid))
                        return true;
                }
            }
        }
        return false;
    }

    boolean isValid(int x, int y, int row, int col) {
        return x >= 0 && x <= row - 1 && y >= 0 && y <= col - 1;
    }
}
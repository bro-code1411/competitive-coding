package dp;

/**
 * There are n house and 3 paints, find minimum cost of painting all the houses when no adjacent can be painted with same color.
 */
public class HousePainting {
    public int solve(int[][] ar, int n) {
        int[][] dp = new int[n][3];
        dp[0][0] = ar[0][0];
        dp[0][1] = ar[0][1];
        dp[0][2] = ar[0][2];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(ar[i][j] + dp[i - 1][1], ar[i][j] + dp[i - 1][2]);
                }
                if (j == 1) {
                    dp[i][j] = Math.min(ar[i][j] + dp[i - 1][0], ar[i][j] + dp[i - 1][2]);
                }
                if (j == 2) {
                    dp[i][j] = Math.min(ar[i][j] + dp[i - 1][0], ar[i][j] + dp[i - 1][1]);
                }
            }
        }
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }
}

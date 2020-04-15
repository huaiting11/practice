package dp;

public class Q63 {
    // 用递推的方式。
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if(obstacleGrid[i][0] != 1){
                dp[i][0] = 1;
            }else {
                dp[i][0] = 0;
            }
        }
        for (int i = 0; i < m; i++) {
            if(obstacleGrid[0][i] != 1){
                dp[0][i] = 1;
            }else {
                dp[0][i] = 0;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n ; j++) {
                if(obstacleGrid[m][n] != 1){
                    dp[m][n] = dp[m -1][n] + dp[m][n -1];
                }else{
                    dp[m][n] =0 ;
                }

            }
        }
        return  dp[m - 1][n - 1];
    }
    public int uniquePathsWithObstacles01(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[width - 1];
    }
}

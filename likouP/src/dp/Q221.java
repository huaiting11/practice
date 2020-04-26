package dp;

public class Q221 {
    /**
     * 暴力法。
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        return 0;

    }
    /**
     * 动态规划
     */
    public int maximalSquare01(char[][] matrix) {
        int maxLen = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1'){
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1],dp[i + 1][j]),dp[i][j]) + 1;
                    maxLen = Math.max(dp[i + 1][j + 1] , maxLen);
                }
            }
        }
        return maxLen * maxLen;
    }
    
}

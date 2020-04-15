package dp;

/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 */
public class Q221_maximal {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;
        int row = matrix.length,col = matrix[0].length;
        int maxLength = 0;
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[row][col] == '1') {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i + 1][j],dp[i][j]),dp[i][j+1]) + 1;
                    maxLength = Math.max(maxLength,dp[i +1][j +1]);
                }
            }
        }
        return maxLength * maxLength;
    }
}

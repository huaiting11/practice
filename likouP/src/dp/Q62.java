package dp;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 */
public class Q62 {
    /**
     * 从上到下。
     * @param m
     * @param n
     * @return  用递归的方法。
     */
    public int uniquePaths(int m, int n) {
        return helper(m -1 , n- 1 ,new int[m][n]);
    }
    int  helper(int m, int n,int[][] res){
        if(m == 0  || n == 0){
            res[m][n] = 1;
            return 1;
        }
        if(res[m][n] != 0 ){
            return res[m][n];
        }

        int result = helper(m -1 ,n,res) + helper(m , n -1 ,res);
        res[m][n] = result;
        return  result;
    }
    // 递推
    public int uniquePaths01(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m ; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i -1][j] + dp[i][j -1];
            }
        }
        return dp[m -1][n - 1];
    }
    public static void main(String[] args) {
        Q62 q62 = new Q62();
        int i = q62.uniquePaths(3,2);
        System.out.println(i);
    }
}

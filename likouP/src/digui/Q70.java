package digui;

public class Q70 {
    public  int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        return  help(n,new int[n + 1]);
    }
    public  int help(int level, int[] temp){
        if(level < 0) return 0;
        if(level == 0) return 1;
        if(temp[level ] != 0) return temp[level];
        temp[level] = help(level -1,temp) + help(level-2,temp);
        return temp[level];
    }



    public int climbStairs01(int n) {
        return climb_Stairs(0, n);
    }
    public int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }
    // 动态规划，不难发现，这个问题可以被分解为一些包含最优子结构的子问题，即它的最优解可以从其子问题的最优解来有效地构建，我们可以
    // 使用动态规划来解决这一问题。
    public int climbStairs02(int n) {
        if(n == 1) return 1;
        int dp[] = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i -1] + dp[i -2];
        }
        return dp[n];
    }


}

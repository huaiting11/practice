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
    // ��̬�滮�����ѷ��֣����������Ա��ֽ�ΪһЩ���������ӽṹ�������⣬���������Ž���Դ�������������Ž�����Ч�ع��������ǿ���
    // ʹ�ö�̬�滮�������һ���⡣
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

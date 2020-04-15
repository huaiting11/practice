package dp;

/**
 * һ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ��Start�� ����
 *
 * ������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ��Finish������
 *
 * ���ܹ��ж�������ͬ��·����
 *
 */
public class Q62 {
    /**
     * ���ϵ��¡�
     * @param m
     * @param n
     * @return  �õݹ�ķ�����
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
    // ����
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

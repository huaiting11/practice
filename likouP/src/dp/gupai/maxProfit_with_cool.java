package dp.gupai;

/**
 * ÿ�� sell ֮��Ҫ��һ����ܼ������ס�ֻҪ������ص�������һ���״̬ת�Ʒ��̼��ɣ�
 *
 * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
 * dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
 * ���ͣ��� i ��ѡ�� buy ��ʱ��Ҫ�� i-2 ��״̬ת�ƣ������� i-1 ��
 *
 */
public class maxProfit_with_cool {
    int maxProfit_with_cool(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0; // ���� dp[i-2][0]
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = temp;
        }
        return dp_i_0;
    }

}

package dp.subsequence;

import java.util.Arrays;

/**
 * ����������У��ĳ��ȡ�
 * dp[i] ��ʾ�� nums[i] �������β������������еĳ��ȡ�
 * ������ �� �Ӵ����������ʵ������Ӵ�һ���������ģ��������� ��һ����������
 https://leetcode-cn.com/problems/longest-increasing-subsequence/
   ���Ƶģ�������ƶ�̬�滮�㷨��������Ҫһ��dp ������ ���ǿ��Լ��裬
 dp[0......1-1] ���Ѿ���
 �������Ȼ�����Լ�����ôͨ����Щ������dp[i]
 ����: [10,9,2,5,3,7,101,18]
 ���: 4
 ����: ��������������� [2,3,7,101]�����ĳ����� 4��

 dp[i] ���������num[i] Ϊ��β�� ����������С�
  dp ����Ӧ��ȫ����ʼ��Ϊ1����Ϊ����������ҲҪ�����Լ������Գ�����СΪ1��
 */
public class lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
       int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
/**
 * dp ��������̣�
 *
 *  ������ȷ dp �����������ݵĺ��壬
 *
 *  Ȼ�����dp ����Ķ��壬������ѧ���ɷ���˼�룬���� dp[0..i-1] ���Ѿ�֪����
 *  ��취��� dp[i], һ����һ����ɣ�������Ŀ�����ͽ����
 *
 *  ����޷������һ�����ܿ��ܾ���dp ����Ķ��岻��ǡ������Ҫ���¶���dp ����ĺ��壬
 *  ���߿���dp[] ����
 *
 */

package dp;

import java.util.LinkedList;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 */
public class Q32_parentheses {
    public int longestValidParentheses(String s) {
        int maxAns = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == ')'){
                if(s.charAt(i-1)=='('){
                    dp[i] = (i > 2 ? dp[i -2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxAns = Math.max(maxAns, dp[i]);
            }
        }
        return dp[s.length()-1];
    }
    public int longestValidParentheses01(String s) {
       LinkedList<Integer> stack = new LinkedList<Integer>();
       stack.push(-1);
       int max = 0 ;
       for (int i = 0; i < s.length(); i++) {
          if(s.charAt(i) == '('){
              stack.push(i);
          }else{
              int pop = stack.poll();
              if(stack.isEmpty()){
                  stack.push(i);
              }else{
                  max = Math.max(max,i - stack.peek());
              }
          }
       }
       return max;
    }

}

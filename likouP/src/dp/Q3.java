package dp;

import java.util.HashSet;
import java.util.Set;

/**
 * 动态规划，最长无重复子串。
 */
public class Q3 {
    /**
     * 暴力求解。
     * @param
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if(judge(j, i,s)){
                    res = Math.max(res, j - i);
                }
            }
        }
        return  res;
    }
    public boolean judge(int start,int end,String s){
        Set  set = new HashSet();
        for (int i =  start ; i  <= end ; i ++){
            if(set.contains(s.charAt(i))){
                return  false;
            }else{
                set.add(s.charAt(i));
            }
        }
        return true;
    }

}

package dp;

import java.util.HashSet;
import java.util.Set;

/**
 * ��̬�滮������ظ��Ӵ���
 */
public class Q3 {
    /**
     * ������⡣
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

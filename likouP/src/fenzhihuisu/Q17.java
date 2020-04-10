package fenzhihuisu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



 示例:

 输入："23"
 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Q17 {
    List<String> res = new ArrayList<>();
    char[] numbers ;
    Map keys = new HashMap<Character,String>();
    public List<String> letterCombinations(String digits) {
        keys.put('2',"abc");
        keys.put('3',"def");
        keys.put('4',"ghi");
        keys.put('5',"jki");
        keys.put('6',"mno");
        keys.put('7',"pqrs");
        keys.put('8',"tuv");
        keys.put('9',"wxyz");
        numbers = digits.toCharArray();
        helper(0,"");
        return res;
    }
    public void helper(int level,String s){
        if(level + 1==  numbers.length){
            res.add(s);
            return;
        }
        String curStr = (String) keys.get(numbers[level]);
        char[] c = curStr.toCharArray();
        for (int i = 0; i < c.length; i++) {
            helper(level + 1, s + c[i]);
        }
    }

    public static void main(String[] args) {
        Q17 d = new Q17();
        d.letterCombinations("23");
    }
}

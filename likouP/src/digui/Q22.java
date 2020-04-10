package digui;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n?代表生成括号的对数，请你设计一个函数，
 * 用于能够生成所有可能的并且
 * 有效的 括号组合
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 */
public class Q22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        help(0,0,"",n,res);
        return res;
    }
    public void help(int left,int right,String s,int n,List<String> res){
        if(s.length() == n * 2){
            res.add(s);
            return;
        }
        if(left < n){
            help(left + 1,right ,s + "(",n,res);
        }
        if(right < n && right < left){
            help(left, right + 1, s + ")",n,res);
        }
    }
}

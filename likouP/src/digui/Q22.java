package digui;

import java.util.ArrayList;
import java.util.List;

/**
 * ���� n?�����������ŵĶ������������һ��������
 * �����ܹ��������п��ܵĲ���
 * ��Ч�� �������
 * ʾ����
 *
 * ���룺n = 3
 * �����[
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

package digui;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 输入: n = 4, k = 2
 */
public class Q77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        help(0,n,k,list,new ArrayList<>());
       // helper(n,1 ,k,result);
        return list;
    }
    public void help(int level,int n,int k,List<List<Integer>> list,List<Integer> temp){
        if(level == k){
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 1; i < n +1; i++) {
            if(temp.contains(i)) continue;
            temp.add(i);
            help(level+1,n,k,list,temp);
            temp.remove(temp.size()-1);
        }
    }
    public static void main(String[] args) {
        Q77 a = new Q77();
        System.out.println(a.combine(4,2));
    }
}

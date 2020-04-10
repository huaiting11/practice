package digui;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Q46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        help(0,nums,list,new ArrayList<>());
        return list;
    }
    public void help(int level,int[] nums,List<List<Integer>> list,List<Integer> temp){
        if(level == nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            help(level+1,nums,list,temp);
            temp.remove(temp.size()-1);
        }
    }
}

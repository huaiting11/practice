package huisu;
// 回溯算法的核心框架

import java.util.LinkedList;
import java.util.List;

/**
 * for 选择 in 选择列表：
 *    # 做选择
 *    将该选择从选择列表移除
 *    路径.add(路径，选择列表)
 *    #撤销选择
 *    路径.remove(选择)
 *    #将该选择再加入选择列表
 */
public class QuanPaiLei {
    List<List<Integer>> res = new LinkedList<>();
    /*主函数，输入一组不重复的数字，返回它们的全排列*/
    List<List<Integer>> permute(int[] nums) {
        // 记录路径。
        LinkedList<Integer> track = new LinkedList<>();
        help(nums,track);
        return  res;
    }

    private void help(int[] nums,LinkedList<Integer> track) {
        if(track.size() == nums.length){
            res.add(new LinkedList(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if(track.contains(nums[i])) continue;
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            help(nums,track);
            // 取消选择 递归回去之后，还有再执行后面的方法。
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        QuanPaiLei quanPaiLei = new QuanPaiLei();
        quanPaiLei.permute(new int[]{1,2});
    }

}
/**
 * 当然，这个算法解决全排列不是很高效，因为对链表使用contains 方法需要o（n）的时间负责对。
 *
 */

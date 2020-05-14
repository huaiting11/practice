package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/  N ²æÊ÷µÄ ²ã¼¶±éÀú

/**
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 */
public class NLevelTravel {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new LinkedList<>();
        if(root == null) return ret;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> curLevel = new LinkedList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node curr = queue.poll();
                curLevel.add(curr.val);
                for (int j = 0; j < curr.children.size(); j++) {
                    queue.offer(curr.children.get(j));
                }
            }
            ret.add(curLevel);
        }
        return ret;
    }
}

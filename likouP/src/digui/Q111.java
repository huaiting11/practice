package digui;

import tree.TreeNode;

public class Q111 {


    /**
     * 错误的解法，很多容易理所当然的跟最大深度，以为改个 min 就可以了，
     * 实际上 ，是不行的。
     * @param root
     * @return
     */
    int help(TreeNode root){
        if(root == null){
            return 0;
        }
        int m = help(root.right);
        int n = help(root.left);
        int max = Math.min(m,n);
        return max + 1;
    }
    /**
     * 另外这道题目的关键是搞清楚递归结束条件
     * 1、叶子节点的定义是左孩子和右孩子 都为null 时，叫做叶子节点
     * 2. 当root 节点左右孩子 都为空时，返回1
     * 3. 当 root ，节点左右孩子有一个为空时，返回不为空的孩子节点的深度
     * 4. 当root 节点左右孩子都不为空，返回左右孩子比较小深度的节点值
     */
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        //2.如果左孩子和由孩子其中一个为空，那么需要返回比较大的那个孩子的深度
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);
        //这里其中一个节点为空，说明m1和m2有一个必然为0，所以可以返回m1 + m2 + 1;
        if(root.left == null || root.right == null) return m1 + m2 + 1;

        //3.最后一种情况，也就是左右孩子都不为空，返回最小深度+1即可
        return Math.min(m1,m2) + 1;
    }
}

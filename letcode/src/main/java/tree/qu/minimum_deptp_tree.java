package tree.qu;

import tree.bean.TreeNode;

/**
 * ���Ҷ���������С��ȡ�
 */
public class minimum_deptp_tree {
    public int minDepth(TreeNode root) {
       if(root != null){
           int leftMax = minDepth(root.left) + 1;
           int rightMax = minDepth(root.right) + 1;
           if(root.left == null || root.right == null){
               return leftMax > rightMax ? leftMax : rightMax;
           }else {
               return leftMax > rightMax ? rightMax : leftMax;
           }
       }else{
           return 0;
       }
    }
}

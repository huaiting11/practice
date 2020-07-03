package tree.qu;

import tree.bean.TreeNode;

public class maximum_depth_tree {
    public int maxDepth(TreeNode root) {
        if(root != null){
            int leftMax = maxDepth(root.left) + 1;
            int rightMax = maxDepth(root.right) + 1;
            return leftMax > rightMax ? leftMax : rightMax;
        }else{
            return 0;
        }
    }
}

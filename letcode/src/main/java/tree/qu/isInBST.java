package tree.qu;

import tree.bean.TreeNode;

public class isInBST {
    boolean isInBST(TreeNode root, int target) {
       if(root == null) return false;
       if(target == root.val) return true;
       return isInBST(root.left,target) && isInBST(root.right ,target);
    }
}

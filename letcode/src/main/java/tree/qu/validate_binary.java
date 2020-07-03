package tree.qu;

import tree.bean.TreeNode;

/**
 * 验证二叉搜索树
 * 一个节点上的 左子树上所有的节点 大于 右子树上的点。
 */
public class validate_binary {
    /**
     * 错误的写法。
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(root.left != null && root.val <= root.left.val) return false;
        if(root.right != null && root.val >= root.right.val) return false;
        return isValidBST(root.left) && isValidBST(root.right); // 对左右子树 进行同样的操作。
    }
    public boolean isValidBST01(TreeNode root) {
        return  help(root, null, null);
    }

    private boolean help(TreeNode root, TreeNode min ,TreeNode max) {
        if(root == null) return true;
        if(min != null &&  root.right.val <= min.val) return false;
        if(max != null && root.left.val >= max.val) return false;
        return help(root.left, min , root) && help(root.right,root,max);

    }

}

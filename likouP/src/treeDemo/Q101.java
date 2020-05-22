package treeDemo;

import tree.TreeNode;

public class Q101 {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.data == t2.data)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }



}

package treeDemo;

import tree.TreeNode;

public class Q100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(q == null || p == null) return false;
        if(p.data != q.data) return false;
        return isSameTree(p.right,q.right) && isSameTree(p.left,q.left);
    }
}

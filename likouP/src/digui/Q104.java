package digui;

import tree.TreeNode;

public class Q104 {
    public int maxDepth(TreeNode root) {
        return help(root);
    }
    int help(TreeNode root){
        if(root == null){
            return 0;
        }
        int m = help(root.right);
        int n = help(root.right);
        int max = Math.min(m,n);
        return max + 1;
    }
}

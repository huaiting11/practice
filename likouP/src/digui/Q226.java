package digui;

import tree.TreeNode;

public class Q226 {
    public TreeNode invertTree(TreeNode root) {
         return help(root);
    }
    TreeNode help(TreeNode root){
        if(root != null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = help(root.right);
        root.right = help(temp);
        return root;
    }
}

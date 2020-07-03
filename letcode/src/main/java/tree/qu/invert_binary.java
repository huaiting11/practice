package tree.qu;

import tree.bean.TreeNode;

public class invert_binary {
    public TreeNode invertTree(TreeNode root) {
        if(root != null){
            TreeNode temp = root.right;
            root.right = root.left;
            root.left =  temp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}

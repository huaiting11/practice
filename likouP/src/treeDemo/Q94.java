package treeDemo;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q94 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        help(root);
        return res;
    }
    public void help(TreeNode root){
        if(root != null){
            inorderTraversal(root.left);
            res.add(root.data);
            inorderTraversal(root.right);
        }
    }
}

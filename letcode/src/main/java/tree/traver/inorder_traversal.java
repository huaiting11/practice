package tree.traver;

import tree.bean.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树，返回它的中序 遍历。 左根右
 */
public class inorder_traversal {
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        // 递归的写法。
        if(root != null){
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }
        return list;
    }
    public List<Integer> inorderTraversal01(TreeNode root) {
        // 迭代的写法。
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;
        while (root != null || !stack.isEmpty()){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                TreeNode node  = stack.pop();
                list.add(node.val);
                root = node.right;
            }
        }
        return list;
    }

}

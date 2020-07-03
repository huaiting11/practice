package tree.traver;

import tree.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 前序遍历、根 左右。
 */
public class preorder_traversal {
    // 递归的写法。
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root != null){
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return list;
    }
    public List<Integer> preorderTraversal01(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()){
            if(node != null){
                list.add(node.val);
                stack.add(node);
                node = node.left;
            }else{
                TreeNode nodes = stack.pop();
                node = nodes.right;
            }
        }
        return list;
    }
}

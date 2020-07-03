package tree.traver;

import tree.bean.TreeNode;

import java.util.*;

/**
 * ����һ���������������������� ������ �����
 */
public class inorder_traversal {
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        // �ݹ��д����
        if(root != null){
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }
        return list;
    }
    public List<Integer> inorderTraversal01(TreeNode root) {
        // ������д����
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

package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
/**
 * ǰ�к���������ǵݹ��д����������д����
 * �㶮���� ˳������ȥд��
 */
public class TreeTravel {
    // ǰ�����
    public List<Integer> preorderTraversal01(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || node != null){
            if(node != null){
                stack.push(node);
                list.add(node.data);
                node = node.left;
            }else if(node == null){
                TreeNode nodes = stack.pop();
                node = nodes.right;
            }
        }
        return list;
    }
    // ������� �����
    public List<Integer> inorderTraversal02(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || node != null){
            if(node != null){
                stack.push(node);
                node = node.left;
            }else{
                TreeNode pop = stack.pop();
                list.add(pop.data);
                node = node.right;
            }
        }
        return list;
    }
    public List<Integer> postorderTraversal01(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.addFirst(p.data);  // Reverse the process of preorder
                p = p.right;             // Reverse the process of preorder
            } else {
                TreeNode node = stack.pop();
                p = node.left;           // Reverse the process of preorder
            }
        }
        return result;
    }
}

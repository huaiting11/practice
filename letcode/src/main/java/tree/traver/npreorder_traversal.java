package tree.traver;

import tree.bean.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * n ²æÊ÷µÄÇ°Ðò±éÀú
 */
public class npreorder_traversal {
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {
        if(root != null){
            list.add(root.val);
            for (Node node :root.children){
                preorder(node);
            }
        }
        return list;
    }
    public List<Integer> preorder12(Node root){
        List<Integer> list = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.isEmpty()){
            root = stack.pop();
            list.add(root.val);
            for (int i = root.children.size() -1; i > 0; i--) {
                stack.push(root.children.get(i));
            }
        }
        return list;
    }
}

package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * n 叉树的 前中后 序遍历
 *
 */
public class NTreval {
    // 后序 递归的写法
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        for ( Node node :root.children ) {
            postorder(node);
        }
        res.add(root.val);
        return res;
    }
    // 前序的递归的写法
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        list.add(root.val);
        for(Node node: root.children)
            preorder(node);

        return list;
    }
    // 前序非递归的写法
    public List<Integer> preorder01(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.empty()) {
            root = stack.pop();
            list.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; i--)
                stack.add(root.children.get(i));
        }

        return list;
    }
    // 后序非递归的写法。
    public List<Integer> postorder01(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            for(Node node: root.children)
                stack.add(node);
        }
        Collections.reverse(list);
        return list;
    }

}

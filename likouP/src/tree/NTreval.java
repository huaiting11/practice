package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * n ������ ǰ�к� �����
 *
 */
public class NTreval {
    // ���� �ݹ��д��
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        for ( Node node :root.children ) {
            postorder(node);
        }
        res.add(root.val);
        return res;
    }
    // ǰ��ĵݹ��д��
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
    // ǰ��ǵݹ��д��
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
    // ����ǵݹ��д����
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

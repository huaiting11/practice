package tree.traver;

import tree.bean.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * n �����ĺ������
 */
public class npostorder_traversal {
    /**
     * �ݹ��д����
     * @param root
     * @return
     *
     *   n ����û������ ����  ����ң�
     *  �� ���ҡ�
     *
     */
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> postorder(Node root) {
        if(root != null){
            for (int i = 0; i < root.children.size(); i++) {
                postorder(root.children.get(i));
            }
            list.add(root.val);
        }
        return list;
    }
    /**
     * �ǵ�����д����
     */
    public List<Integer> postorder01(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        Stack<Node> stack = new Stack<Node>();
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

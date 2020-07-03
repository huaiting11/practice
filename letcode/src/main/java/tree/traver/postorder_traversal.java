package tree.traver;

import tree.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * ������� ���Ҹ�
 *  �����ҡ�
 */
public class postorder_traversal {
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root != null){
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            list.add(root.val);
        }
        return list;
    }
}

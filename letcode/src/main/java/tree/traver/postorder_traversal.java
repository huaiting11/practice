package tree.traver;

import tree.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * ºóĞò±éÀú ×óÓÒ¸ú
 *  ¸ú×óÓÒ¡£
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

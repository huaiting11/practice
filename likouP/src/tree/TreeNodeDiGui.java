package tree;

import java.util.*;

/**
 *  ǰ��������� �ݹ��д����
 *
 */
public class TreeNodeDiGui {
    public void preOrderTraverse1(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + "->");
            preOrderTraverse1(root.left);
            preOrderTraverse1(root.right);
        }
    }
    public void inOrderTraverse(TreeNode root) {
        if (root != null) {
            inOrderTraverse(root.left);
            System.out.print(root.data + "->");
            inOrderTraverse(root.right);
        }
    }
    public void postOrderTraverse(TreeNode root) {
        if (root != null) {
            postOrderTraverse(root.left);
            postOrderTraverse(root.right);
            System.out.print(root.data + "->");
        }
    }


}

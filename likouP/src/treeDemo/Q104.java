package treeDemo;

import tree.TreeNode;

/**
 * ����һ�����������ҳ��������ȡ�
 *
 * �����������Ϊ���ڵ㵽��ԶҶ�ӽڵ���·���ϵĽڵ�����
 *
 * ˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
 */
public class Q104 {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left) ,maxDepth(root.right)) + 1;
    }
}

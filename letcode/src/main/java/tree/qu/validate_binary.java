package tree.qu;

import tree.bean.TreeNode;

/**
 * ��֤����������
 * һ���ڵ��ϵ� �����������еĽڵ� ���� �������ϵĵ㡣
 */
public class validate_binary {
    /**
     * �����д����
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(root.left != null && root.val <= root.left.val) return false;
        if(root.right != null && root.val >= root.right.val) return false;
        return isValidBST(root.left) && isValidBST(root.right); // ���������� ����ͬ���Ĳ�����
    }
    public boolean isValidBST01(TreeNode root) {
        return  help(root, null, null);
    }

    private boolean help(TreeNode root, TreeNode min ,TreeNode max) {
        if(root == null) return true;
        if(min != null &&  root.right.val <= min.val) return false;
        if(max != null && root.left.val >= max.val) return false;
        return help(root.left, min , root) && help(root.right,root,max);

    }

}

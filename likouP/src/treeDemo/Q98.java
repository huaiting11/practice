package treeDemo;

import tree.TreeNode;
//�����һ�������Сֵ�����޶�ÿ���ڵ����Чȡֵ��Χ��������һ���ڵ�root��ȡֵ��ΧΪ**��min,max����
// ������Ů��ȡֵ��ΧΪ��min,root.val��,����Ů��ȡֵ��Χ�ǣ�root.val,max��������ִ����ȥ��
// һ����⵽�ڵ�ֵ���������Χ�򷵻�false**������̫�����ˡ����о����ڴ��������ԭ�������ܹ����������Сֵ�������¶�����һ���������ã�ֵ��ѧϰ��
/// ��֤�Ƿ���
public class Q98 {
    public boolean isValidBST(TreeNode root){
        return help(root,null,null);
    }
    boolean help(TreeNode node,Integer lower,Integer upper){
        if(node == null) return  true;
        int val = node.data;
        if(lower != null && val <= lower) return false;
        if(upper != null && val >= upper) return false;
        if(!help(node.right,val,upper)) return false;
        if(!help(node.left,lower,val)) return false;
        return true;
    }
}

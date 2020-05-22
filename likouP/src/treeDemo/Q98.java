package treeDemo;

import tree.TreeNode;
//添加了一个最大最小值，来限定每个节点的有效取值范围。假设任一根节点root的取值范围为**（min,max），
// 则左子女的取值范围为（min,root.val）,右子女的取值范围是（root.val,max），依次执行下去，
// 一旦检测到节点值不在这个范围则返回false**。真是太机智了。还有就是在传输过程中原函数不能够传递最大最小值，又重新定义了一个函数调用，值得学习。
/// 验证是否是
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

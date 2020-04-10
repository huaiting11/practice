package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//前序遍历 n叉树 根 左右
// n 叉树。
public class Q589 {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        help(root,res);
        return res;

    }
    // 递归的写写法。
    public void help(Node root,List<Integer> res){
        if(root != null){
            res.add(root.val);
            for (int i = 0; i < root.children.size(); i++) {
                help(root.children.get(i),res);
            }
        }
    }
    //  用栈 跟迭代 来处理 ，速度会快一点。
    public List<Integer> preorder01(Node root) {
       Stack<Node> stack = new Stack<>();
       List<Integer> res = new ArrayList<>();
       if(root == null){
           return  res;
       }
       stack.add(root);
       while (!stack.isEmpty()){
           Node top = stack.pop();
           res.add(top.val);
           for (int i = top.children.size()-1; i >= 0 ; i--) {
               stack.push(top.children.get(i));
           }
       }
       return res;
    }



}

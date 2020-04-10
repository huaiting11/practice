package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    TreeNode root;
    public void addNode(int value){
        root = addNode(root,value);
    }
    private TreeNode addNode(TreeNode current,int value){
        if(current == null){
            return new TreeNode(value);
        }
        if(value < current.data){
            current.left = addNode(current.left, value);
        }else if(value > current.data){
            current.right = addNode(current.right,value);
        }else {
            return current;
        }
        return current;
    }
    public void traverseInOrder(TreeNode root){
        if(root != null){
            if(root.left != null){
                traverseInOrder(root.left);
            }
            System.out.println(root.data);
            if(root.right != null){
                traverseInOrder(root.right);
            }
        }
    }
    public void traversePreOrder(TreeNode root){
        if(root != null){
            System.out.println(root.data);
            if(root.left != null) {
                traversePreOrder(root.left);
            }
            if(root.right != null){
                traversePreOrder(root.left);
            }
        }
    }
    public void traversePostOrder(TreeNode root){
        if(root != null){
            traversePostOrder(root.left);
            traversePostOrder(root.right);
            System.out.println(root.data);
        }
    }
    public void traverseLevelOrder(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            TreeNode node = nodes.remove();
            System.out.println(node.data);
            if(node.left != null){
                nodes.add(node.left);
            }
            if(node.right != null){
                nodes.add(node.right);
            }
        }
    }

}

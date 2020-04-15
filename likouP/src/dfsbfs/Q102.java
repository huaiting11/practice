package dfsbfs;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * ����һ�������������㷵���䰴 ������� �õ��Ľڵ�ֵ�� �������أ������ҷ������нڵ㣩��
 */
public class Q102 {
    /**
     * ���е���ʽд�ġ�
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if(root == null){
            return levels;
        }else{
            Queue<TreeNode> que = new ArrayDeque<>();
            que.add(root);
            int level = 0;
            while (!que.isEmpty()){
                levels.add(new ArrayList<Integer>());
                int size = que.size();
                for (int i = 0; i < size; i++) {
                    TreeNode top = que.poll();
                    levels.get(level).add(top.data);
                    if(top.left != null){
                        que.add(top.left);
                    }
                    if(top.right != null){
                        que.add(top.right);
                    }
                }
                level++;
            }
        }
        return levels;
    }
}

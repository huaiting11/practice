package digui;

import tree.TreeNode;

public class Q111 {


    /**
     * ����Ľⷨ���ܶ�����������Ȼ�ĸ������ȣ���Ϊ�ĸ� min �Ϳ����ˣ�
     * ʵ���� ���ǲ��еġ�
     * @param root
     * @return
     */
    int help(TreeNode root){
        if(root == null){
            return 0;
        }
        int m = help(root.right);
        int n = help(root.left);
        int max = Math.min(m,n);
        return max + 1;
    }
    /**
     * ���������Ŀ�Ĺؼ��Ǹ�����ݹ��������
     * 1��Ҷ�ӽڵ�Ķ��������Ӻ��Һ��� ��Ϊnull ʱ������Ҷ�ӽڵ�
     * 2. ��root �ڵ����Һ��� ��Ϊ��ʱ������1
     * 3. �� root ���ڵ����Һ�����һ��Ϊ��ʱ�����ز�Ϊ�յĺ��ӽڵ�����
     * 4. ��root �ڵ����Һ��Ӷ���Ϊ�գ��������Һ��ӱȽ�С��ȵĽڵ�ֵ
     */
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        //2.������Ӻ��ɺ�������һ��Ϊ�գ���ô��Ҫ���رȽϴ���Ǹ����ӵ����
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);
        //��������һ���ڵ�Ϊ�գ�˵��m1��m2��һ����ȻΪ0�����Կ��Է���m1 + m2 + 1;
        if(root.left == null || root.right == null) return m1 + m2 + 1;

        //3.���һ�������Ҳ�������Һ��Ӷ���Ϊ�գ�������С���+1����
        return Math.min(m1,m2) + 1;
    }
}

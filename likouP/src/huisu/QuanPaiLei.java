package huisu;
// �����㷨�ĺ��Ŀ��

import java.util.LinkedList;
import java.util.List;

/**
 * for ѡ�� in ѡ���б�
 *    # ��ѡ��
 *    ����ѡ���ѡ���б��Ƴ�
 *    ·��.add(·����ѡ���б�)
 *    #����ѡ��
 *    ·��.remove(ѡ��)
 *    #����ѡ���ټ���ѡ���б�
 */
public class QuanPaiLei {
    List<List<Integer>> res = new LinkedList<>();
    /*������������һ�鲻�ظ������֣��������ǵ�ȫ����*/
    List<List<Integer>> permute(int[] nums) {
        // ��¼·����
        LinkedList<Integer> track = new LinkedList<>();
        help(nums,track);
        return  res;
    }

    private void help(int[] nums,LinkedList<Integer> track) {
        if(track.size() == nums.length){
            res.add(new LinkedList(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // �ų����Ϸ���ѡ��
            if(track.contains(nums[i])) continue;
            // ��ѡ��
            track.add(nums[i]);
            // ������һ�������
            help(nums,track);
            // ȡ��ѡ�� �ݹ��ȥ֮�󣬻�����ִ�к���ķ�����
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        QuanPaiLei quanPaiLei = new QuanPaiLei();
        quanPaiLei.permute(new int[]{1,2});
    }

}
/**
 * ��Ȼ������㷨���ȫ���в��Ǻܸ�Ч����Ϊ������ʹ��contains ������Ҫo��n����ʱ�为��ԡ�
 *
 */

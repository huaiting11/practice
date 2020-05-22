package union;

import com.sun.org.apache.regexp.internal.RE;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ����Ȧ��������õĽⷨ�ǲ��鼯������Ϊ�˹��̷����������������
 * ����:
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * ���: 2
 * ˵������֪ѧ��0��ѧ��1��Ϊ���ѣ�������һ������Ȧ��
 * ��2��ѧ���Լ���һ������Ȧ�����Է���2��
 */
public class Q547 {
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < M.length; i++) {
            if(visited[i] == 0){
                queue.add(i);
                while (!queue.isEmpty()){
                    int s = queue.remove();
                    visited[s] = 1;
                    for (int j = 0; j < M.length; j++) {
                        if(M[s][j] == 1 && visited[j] == 0){
                            queue.add(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
}

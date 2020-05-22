package union;

import com.sun.org.apache.regexp.internal.RE;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 朋友圈数量，最好的解法是并查集，但是为了巩固方法，广度优先搜索
 * 输入:
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * 输出: 2
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
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

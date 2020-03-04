package qifashisousuo;

import sun.font.TrueTypeGlyphMapper;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。
 *
 * 一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成：
 *
 * 相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角）
 * C_1 位于 (0, 0)（即，值为 grid[0][0]）
 * C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]）
 * 如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0）
 * 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。
 */
public class Q1091 {
    private int dir[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        LinkedList<Integer> linkList = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0] == 1 || grid[m -1][n-1] == 1)return -1;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.add(new int[]{0,0});
        int res = 0;
        if(!queue.isEmpty()){
            int size = queue.size();
            for (int l = 0; l < size; l++) {
                int[] pop = queue.remove();
                int x = pop[0];
                int y = pop[1];
                if(x == m -1 && y == n -1) return res+1;
                for (int k = 0; k < 8; k++) {
                    int nextX = x + dir[k][0];
                    int nextY = y + dir[k][1];
                    if(nextX > 0 && nextX < m && nextY > 0 && nextY < n && !visited[nextX][nextY] && grid[nextX][nextY]==0){
                        queue.add(new int[]{nextX,nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
            res++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Q1091 q109 = new Q1091();
       int x =  q109.shortestPathBinaryMatrix(new int[][]{{1,0,0},{1,1,0},{1,1,0}});
        System.out.println(x);
    }
}

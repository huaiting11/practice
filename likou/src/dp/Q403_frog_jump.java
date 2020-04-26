package dp;

import java.lang.reflect.Array;
import java.util.*;

public class Q403_frog_jump {
    int[][] temp;

    /**
     * 记忆化搜索，通过，递归。
     * @param stones
     * @return
     */
    public boolean canCross(int[] stones) {
        temp = new int[stones.length][stones.length];
        for (int[] row : temp) {
            Arrays.fill(row, -1);
        }
        return help(stones,0,0) == 1;
    }

    private int help(int[] stones, int start, int jumpSize) {
        if(temp[start][jumpSize] >= 0) return temp[start][jumpSize];
        for (int i = start + 1; i < stones.length; i++) {
            int jump = stones[i] - stones[start];
            if(jump >= jumpSize - 1 && jump <= jumpSize +1){
               if(help(stones,i,jump) == 1){
                   temp[i][jump] =1;
                   return 1;
               }
            }
        }
        temp[start][jumpSize] = (start == stones.length - 1) ? 1 : 0;
        return temp[start][jumpSize] ;

    }

    /**
     * 动态规划
     * @param stones
     * @return
     */
    public boolean canCross01(int[] stones) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<Integer>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for (int k : map.get(stones[i])) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(stones[i] + step)) {
                        map.get(stones[i] + step).add(step);
                    }
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() > 0;
    }

}

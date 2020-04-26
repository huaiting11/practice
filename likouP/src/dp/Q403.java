package dp;

import java.util.*;

public class Q403 {
    // ¼ÇÒä»¯£¬ËÑË÷
    int[][] temp ;
    public boolean canCross(int[] stones) {
        temp = new int[stones.length][stones.length];
        for(int[] row : temp){
            Arrays.fill(row, - 1);
        }
        return  help(stones , 0 ,0)  !=  -1 ? true : false;
    }

    private int help(int[] stones, int current, int jump) {
        if(temp[current][jump] != -1 ){
            return temp[current][jump];
        }
        for (int i = current + 1; i < stones.length; i++) {
            int jumpSize = stones[i] - stones[current];
            if(jumpSize >= jump - 1 && jumpSize <= jump + 1){
               return  help(stones , i , jumpSize);
            }
        }
        return  current == stones.length - 1 ?  0 :  -1 ;
    }
    public boolean canCross01(int[] stones){
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i] , new HashSet());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for (int k : map.get(stones[i])) {
                for (int j = k - 1; j <= k + 1 ; j++) {
                    if(j > 0 && map.containsKey(j + stones[i])){
                        map.get(j + stones[i]).add(j);
                    }
                }
            }
        }
        if(map.get(stones[stones.length - 1]).size() > 0 ) {
            return  true;
        }else{
            return  false;
        }
    }

}

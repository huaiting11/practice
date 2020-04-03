package stack;

import com.sun.javafx.robot.FXRobotImage;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class Q84 {

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if(len == 0 ){
            return  0;
        }else if(len == 1){
            return heights[0];
        }
        int res = 0;

        /**
         * 增加哨兵节点。
         */
        int[] newH = new int[len + 2];
        newH[0] = 0;
        System.arraycopy(heights, 0, newH, 1, len);
        newH[len + 1] = 0;
        len += 2;
        heights = newH;
        Deque<Integer> stack = new ArrayDeque<>(len);
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]){
                int height = heights[stack.pollLast()];
                while (!stack.isEmpty() && heights[stack.peekLast()] == height){
                    stack.pollLast();
                }
                res = Math.max(res,height * (i - stack.peekLast() - 1) );
            }
            stack.add(i);
        }
        return res;
    }
}

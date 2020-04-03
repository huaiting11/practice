package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.logging.Level;

public class Q42 {
    public int trap(int[] height) {
        int len = height.length;
        /*льеп╤о*/
        if(len < 3){
            return 0;
        }
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>(len);
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peekLast()]){
                int he = stack.pollLast();
                if(stack.isEmpty()) break;
                int stance = i - stack.peekLast() - 1;
                int min = Math.min(height[stack.peekLast()],height[i]) - height[he];
                res += min * stance;
            }
            stack.add(i);
        }
        return res;
    }

}

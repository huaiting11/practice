package array;

public class Q11 {
    public int maxArea(int[] height) {
        int end = height.length;
        int start = 0;
        int maxArea = 0;
        while (start < end){
            boolean flag = height[end] < height[start];
            if(flag){
                maxArea = Math.max(maxArea,(end - start) * height[end] );
                end--;
            }else{
                maxArea = Math.max(maxArea,(end - start) * height[start] );
                start++;
            }
        }
        return maxArea;
    }


}

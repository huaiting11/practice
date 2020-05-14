package erfen;

public class Q35 {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0) return 0;
        int left = 0, right = nums.length;
        while (left < right){
            int mid = (left + right) >>> 1;
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;

    }

    public static void main(String[] args) {
        Q35 q =new Q35();
        int i = q.searchInsert(new int[]{1, 3, 5, 6}, 5);
        System.out.println(i);
    }

}

package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 三数之和
 */
public class Q15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res =  new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[0] > 0 ) return res;
            int l = i + 1 , r = nums.length;
            if(i  > 0 && nums[i] == nums[i - 1]) continue;
            while (l < r){
                int sum = nums[i] + nums[r] + nums[l];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i],nums[r],nums[l]));
                    while (l < r && nums[l] == nums[l+1] ){
                        l++;
                    }
                    while (l < r && nums[r] == nums[r-1]){
                        r--;
                    }
                    l++;
                    r--;

                }else if(sum < 0 ){
                    l ++;
                }else {
                    r--;
                }

            }
        }
        return res;

    }
}

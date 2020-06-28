package arrayExercise;

import java.util.Arrays;
import java.util.Collections;

public class Test_16 {
//            3 <= nums.length <= 10^3
//            -10^3 <= nums[i] <= 10^3
//            -10^4 <= target <= 10^4

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int best = 10000;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int j = i+1, k=nums.length-1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target)
                    return target;
                if (Math.abs(sum - target) < Math.abs(best - target))
                    best = sum;
                if (sum > target) {
                    int k0;
                    do { k0 = k--; }
                    while (k > j && nums[k0] == nums[k]);
                }else {
                    int j0;
                    do { j0 = j++; }
                    while (j < k && nums[j0] == nums[j]);
                }
            }
        }
        return best;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4, 10, 20, 30, 50, 100, 20, 20, 60, 40, 60, 80};
        int[] copynums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copynums);
        System.out.println(Arrays.toString(copynums));
        System.out.println(threeSumClosest(nums, 70));
    }
}

package DynamicProgramming;

public class Test_152_R {

    public static int maxProduct(int[] nums) {
        int result = nums[0], max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            if(max > result) result = max;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}

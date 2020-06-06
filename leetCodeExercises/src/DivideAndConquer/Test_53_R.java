package DivideAndConquer;

public class Test_53_R {
    public static void main(String[] args) {

    }

    //动规划
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && (nums[i-1]+nums[i])>nums[i]){
                nums[i]+=nums[i-1];
            }
            if(nums[i]>max)
                max = nums[i];
        }
        return max;
    }
    //尝试分治算法

}

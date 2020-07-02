package arrayExercise;

public class Test_704_r {
    public int search(int[] nums, int target) {
        int n=nums.length,left = 0,right = n;
        while (left < right) {
            int mid=left+ ((right-left)>>1);
            if (nums[mid] < target) {
                left = mid+1;
            }else {
                right = mid;
            }
            if (left == right) return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        Test_704_r t = new Test_704_r();
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(t.search(nums, 9));
    }
}

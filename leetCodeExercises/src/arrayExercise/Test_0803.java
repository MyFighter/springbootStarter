package arrayExercise;

public class Test_0803 {

    public int findMagicIndex(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            if (nums[i] == i)
                return i;
        }
        return -1;
    }

    //跳跃性优化
    public static int findMagicIndex2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i)
                return i;
            if (nums[i] > i) i = nums[i];
            else i++;

        }
        return -1;
    }

    public static int binarySearch(int b, int e,int[] nums,int key) {
        if (b > e) return -1;
        int m = (b - e)/2 + e;
        if (key > nums[m]) return binarySearch(m+1, e, nums, key);
        if (key < nums[m]) return binarySearch(b, m-1, nums, key);
        return m;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 6, 8, 8, 8, 8};
        // 4.5 4 5 8
        int[] nums2 = {0, 2, 3, 4, 5};
        System.out.println(binarySearch(0, nums.length, nums, 3));
    }
}

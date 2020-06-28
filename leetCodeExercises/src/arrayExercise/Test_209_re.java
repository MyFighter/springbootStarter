package arrayExercise;

import java.util.Deque;
import java.util.LinkedList;

//2,3,1,2,4,3
public class Test_209_re {
    //self
    public static int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        Deque<Integer> deque = new LinkedList<>();
        int count = nums.length+1;
        int sum = 0;
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i] >= s)
                return 1;
            else {
                sum += nums[i];
                deque.add(nums[i]);
                if (sum >= s) {
                    while (!deque.isEmpty() && (sum - deque.peek()) >= s) {
                        sum -= deque.pop();
                    }
                    if (deque.size() < count) count = deque.size();
                }
            }
        }
        if (count > nums.length) return 0;
        else return count;
    }
    //逻辑类似，但是双指针就可以了，而且更快，没必要用队列
    public int minSubArrayLen2(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, arr));
    }
}

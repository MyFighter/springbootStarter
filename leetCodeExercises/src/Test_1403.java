import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test_1403 {
    public static void main(String[] args) {
        int[] nums = {4,3,10,9,8};
        System.out.println(minSubsequence(nums).toString());
    }

    public static List<Integer> minSubsequence(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if( nums.length < 2){
            res.add(nums[0]);
            return res;
        }
        int total=0,currTotal=0;
        int[] t = new int[101];
        for (int i : nums) {
            t[i]++;
            total+=i;
        }
        for (int i = 100; i >=0 && (currTotal <= total-currTotal);i --){
            if(t[i] > 0){
                while (t[i] > 0 && (currTotal <= total-currTotal)){
                    currTotal += i;
                    t[i]--;
                    res.add(i);
                }
            }
        }
        return res;
    }
}

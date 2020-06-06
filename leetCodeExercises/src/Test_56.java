import java.util.*;

public class Test_56 {
    public static void main(String[] args) {
        int[] nums = {1,2,10,4,1,4,3,3};
        int[] ints = singleNumbers(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+",");
        }
    }

    public static int[] singleNumbers(int[] nums) {
        int sum = 0;
        for (int i = 0; i <nums.length; i++) {
            sum ^= nums[i];
        }
        int f = 1;
        while ((sum&f) ==0){
            f=f<<1;
        }
        int a=0,b=0;
        for (int i : nums){
            if((i&f)==0){
                a ^= i;
            }else{
                b ^= i;
            }
        }
        int[] res = new int[2];
        res[0] = a;
        res[1] = b;
        return res;
    }
}

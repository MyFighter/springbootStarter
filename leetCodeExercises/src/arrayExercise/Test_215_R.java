package arrayExercise;

import java.util.Arrays;

public class Test_215_R {
    //快速排序
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public static void main(String[] args) {
//        int[] arr = {3,2,1,5,6,4};
//        quickSort(arr, 0, arr.length-1);
//        System.out.println(Arrays.toString(arr));


        int[] arr = {1, 2, 3};
        partition(arr, 1, 2);
        System.out.println(Arrays.toString(arr));
        //4
//        System.out.println(findKthLargest(arr, 4));
    }

    public static void quickSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = partition(arr, p, r);
            quickSort(arr, p, q-1);
            quickSort(arr, q+1, r);
            /*
            * 0, 10
            * 0, 5
            * 0, 2
            * 3, 5
            * 6, 10
            * */
        }
    }

    //2,8,7,1,3,5,6,4
    //1, 2, 3
    public static int partition(int[] arr, int p, int r) {
        int x = arr[r];
        int i = p - 1;
        for (int j = p; j <= r-1; j++) {
            if ( arr[j] <= x) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, r);
        return i+1;
    }

    public static void swap (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

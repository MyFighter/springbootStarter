package arrayExercise;

//堆
public class Test_378_R {
    /**
     *       1,  5,  9
     *      1, 11, 13
     *      1, 13, 15
     *      1, 16, 19
     */
    //暴力
/*    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] sorted = new int[n*n];
        for (int i = 0,s=0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sorted[s++] = matrix[i][j];
            }
        }
        Arrays.sort(sorted);
        return sorted[k-1];
    }*/

    //二分查找
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    /**
     *       1,  5,  9
     *      10, 11, 13
     *      12, 13, 15
     */
    //mid=8,k=8,n=3,i=2
    public boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }

    public static void main(String[] args) {
        Test_378_R test_378R = new Test_378_R();
        int[][] matrix = {{ 1,  5,  9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(test_378R.kthSmallest(matrix, 8));
    }
}

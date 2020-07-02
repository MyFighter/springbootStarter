package arrayExercise;

import java.util.HashSet;
import java.util.Set;

public class Test_718_R {
//    Input:
//    A: [1,2,3,2,1]
//    B: [3,2,1,4,7]
//    Output: 3
    //暴力
    /*public static int findLength(int[] A, int[] B) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int ti=i,tj=j,tmax=0;
                while (ti>=0 && tj>=0 && A[ti] == B[tj]) {
                    ti--;tj--;tmax++;
                }
                max = Math.max(max, tmax);
            }
        }
        return max;
    }*/
    //DP：用二维数组保存A[i]和B[j]的公共前缀
/*    public static int findLength(int[] A, int[] B) {
        int max = 0;
        int[][] dt = new int[A.length+1][B.length+1];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int k = dt[i][j];
                dt[i+1][j+1] = A[i]==B[j]?dt[i][j]+1:0;
                max = Math.max(max, dt[i+1][j+1]);
            }
        }
        return max;
    }*/
    //滑动窗口
/*    public static int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            int len = Math.min(m, n - i);
            int maxlen = maxLength(A, B, i, 0, len);
            ret = Math.max(ret, maxlen);
        }
        for (int i = 0; i < m; i++) {
            int len = Math.min(n, m - i);
            int maxlen = maxLength(A, B, 0, i, len);
            ret = Math.max(ret, maxlen);
        }
        return ret;
    }
    public static int maxLength(int[] A, int[] B, int addA, int addB, int len) {
        int ret = 0, k = 0;
        for (int i = 0; i < len; i++) {
            if (A[addA + i] == B[addB + i]) {
                k++;
            } else {
                k = 0;
            }
            ret = Math.max(ret, k);
        }
        return ret;
    }*/
    //    二分查找 + 哈希
    int mod = 1000000009;
    int base = 113;

    public int findLength(int[] A, int[] B) {
        int left = 1, right = Math.min(A.length, B.length) + 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (check(A, B, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }
    public boolean check(int[] A, int[] B, int len) {
        long hashA = 0;
        for (int i = 0; i < len; i++) {
            hashA = (hashA * base + A[i]) % mod;
        }
        Set<Long> bucketA = new HashSet<Long>();
        bucketA.add(hashA);
        long mult = qPow(base, len - 1);
        for (int i = len; i < A.length; i++) {
            hashA = ((hashA - A[i - len] * mult % mod + mod) % mod * base + A[i]) % mod;
            bucketA.add(hashA);
        }
        long hashB = 0;
        for (int i = 0; i < len; i++) {
            hashB = (hashB * base + B[i]) % mod;
        }
        if (bucketA.contains(hashB)) {
            return true;
        }
        for (int i = len; i < B.length; i++) {
            hashB = ((hashB - B[i - len] * mult % mod + mod) % mod * base + B[i]) % mod;
            if (bucketA.contains(hashB)) {
                return true;
            }
        }
        return false;
    }
    // 使用快速幂计算 x^n % mod 的值
    public long qPow(long x, long n) {
        long ret = 1;
        while (n != 0) {
            if ((n & 1) != 0) {
                ret = ret * x % mod;
            }
            x = x * x % mod;
            n >>= 1;
        }
        return ret;
    }



    public static void main(String[] args) {
        /**
         * 2,2,2,3
         * 2,2,2,2,3
         */
        int[] a = {1,2,4,3,2,1};
        int[] b = {3,1,2,4,7,4,3,2,1,4,5};
        Test_718_R t = new Test_718_R();
        System.out.println(t.findLength(a, b));
    }
}

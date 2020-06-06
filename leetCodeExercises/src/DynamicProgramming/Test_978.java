package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class Test_978 {
    public static int maxTurbulenceSize(int[] A) {
        int maxL = 1;
        int isBig = 0;
        for (int i = 0; i < A.length-1; i++) {
            if(Integer.compare(A[i], A[i+1]) != isBig && Integer.compare(A[i], A[i+1]) != 0){
                isBig = Integer.compare(A[i], A[i+1]);
                if(i == 0){
                    A[i] = 2;
                }else{
                    A[i] = A[i-1]+1;
                }
            }else{
                isBig = Integer.compare(A[i], A[i+1]);
                if(Integer.compare(A[i], A[i+1]) != 0){
                    A[i] = 2;
                }else{
                    A[i] = 1;
                }
            }
            if(A[i] > maxL){ maxL = A[i]; }
        }
        return maxL;
    }

    public static int maxTurbulenceSize2(int[] A) {
        int[] compare = new int[A.length-1];
        for (int i = 0,j=1; j<A.length; i++,j++) {
            compare[j-1] = Integer.compare(A[i], A[j]);
        }
        int maxL = 0;
        int cL = 0;
        for (int i = 0,j=1; j < compare.length; i++,j++) {
            if(Math.abs(compare[i]-compare[j]) == 2){
                cL=cL==0?2:cL+1;
            }else{
                cL=0;
            }
            if(cL > maxL){
                maxL = cL;
            }
        }
        return maxL+1;
    }


    public static void main(String[] args) {
        //TODO  to be optimezed
//        int[] te = {9,4,2,10,7,8,8,1,9};
//        int[] te = {8,8,9,4,2,10,7,1,9};
//        int[] te = {1,1};
        int[] te = {12,16};
//        int[] te2 ={8, 9, 4, 2, 10, 7, 1, 9};
        //          0, 1, 1, 1, -1, 1, 1, -1
        //          -1, 1, -1, -1, 1, -1, 1
        //           1, -1, -1, 1, -1, 1
        //           1, 0, 1, -1
        //           0, 1,
//        System.out.println(maxTurbulenceSize(te));
        System.out.println(maxTurbulenceSize2(te));
        System.out.println(Arrays.toString(te));
    }
}

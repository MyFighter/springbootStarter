package arrayExercise;

public class Test_29 {
    //j++ i++ j-- i--
    public static int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int[] res = new int[matrix.length*matrix[0].length];
        int r=0,i=0,j=0,rb=0,re=matrix.length-1,cb=0,ce=matrix[0].length-1;
        while (true){
            while ( j < ce)
                res[r++] = matrix[i][j++];
            j=ce;rb++;
            if ( rb > re) break;
            while ( i < re)
                res[r++] = matrix[i++][j];
            i=re;ce--;
            if (cb > ce) break;
            while ( j > cb)
                res[r++] = matrix[i][j--];
            j=cb;re--;
            if (rb > re) break;
            while ( i > rb)
                res[r++] = matrix[i--][j];
            i=rb;cb++;
            if (cb > ce) break;
        }
        res[r++] = matrix[i][j];
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = new int[0][0];
        initData(arr);
        int[] res = spiralOrder(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    private static void initData(int[][] arr) {
        int v = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = ++v;
                System.out.print(arr[i][j]+ "\t");
            }
            System.out.println();
        }
    }


}

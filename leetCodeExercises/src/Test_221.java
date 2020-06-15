public class Test_221 {

    public static int maximalSquare(char[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        int[][] posLen = new int[matrix.length][matrix[0].length];
        int maxLen = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[i].length ; j++) {
                if(i > 0 && j > 0){
                    if(matrix[i][j] == '1')
                        posLen[i][j] = Math.min(Math.min(posLen[i-1][j], posLen[i][j-1]),posLen[i-1][j-1])+1;
                }else{
                    posLen[i][j] = matrix[i][j]-48;
                }
                maxLen = posLen[i][j] > maxLen? posLen[i][j]: maxLen;
            }
        }
        return maxLen*maxLen;
    }

    public static void main(String[] args) {
        char[][] m = new char[1][1];
        m[0][0]='1';
        System.out.println(maximalSquare(m));
    }
}

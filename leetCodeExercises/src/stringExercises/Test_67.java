package stringExercises;

public class Test_67 {
//    Input: a = "1010", b = "1011"
//    Output: "10101"
    //         1010
    //         1011
    //        10101

    //         1010
    //         1111
    //        11001

    //        1110         11
    //        1111         11
    //       11100        110
    public String addBinary(String a, String b) {
        int la = a.length(),lb = b.length(),n=0;
        StringBuilder sb = new StringBuilder();
         do {
            char ca = a.charAt(--la);
            char cb = b.charAt(--lb);
            sb.append( (ca ^ cb) ^ n);
            n = (ca ^ cb & n) | (ca & cb | n);
            //  0    0  1 ->0 
            //  0    1  1 ->1
            //  1    1  1 ->1
            //  0    0  0 ->0
             //  0   1  0 ->0
             //  1   1  0 ->1
        } while (la > 0 && lb > 0);
        return null;
    }

    public static void main(String[] args) {
        System.out.println('1' ^ '1');
    }
}

import java.util.ArrayList;
import java.util.Stack;

public class Test_1111 {
    public static int[] maxDepthAfterSplit(String seq) {
        int[] res = new int[seq.length()];
        int depth = 0;
        for (int i = 0; i < seq.length();i++) {
            if(seq.charAt(i)=='('){
                res[i] = ++depth %2;
            }else{
                res[i] = depth-- %2;
            }
        }
        return res;
    }
    //(())
//   ((((((( ((())) ((())) )))))))
    public static void main(String[] args) {
        String seq = "((((()))())(())())(()())(())";
        int[] x = maxDepthAfterSplit(seq);
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i]+ " ");
        }
        String s = "";
        for (int i = 0; i < seq.length(); i++) {
            if(x[i]!=0){
                s+=seq.charAt(i);
            }
        }
        System.out.println("");
        System.out.println(s);
        System.out.println(maxDepthAfterSplit(s));
    }
}

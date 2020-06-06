import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Test_1249 {

    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] chs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0,sum = 0; i <chs.length ; i++) {
            if(chs[i] == '('){
                stack.push(i);
                sum++;
            }else if(chs[i]==')' && sum > 0){
                stack.pop();
                sum--;
            }else if(chs[i]==')' && sum <= 0){
                chs[i] = 1;
            }
        }
        while(!stack.isEmpty()){
            chs[stack.pop()] = 1;
        }
        for (int i = 0; i < chs.length ; i++) {
            if(chs[i] != 1){
                sb.append(chs[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
    }
}

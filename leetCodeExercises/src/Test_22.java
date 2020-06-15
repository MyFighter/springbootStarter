import java.util.ArrayList;
import java.util.List;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
/*输入：n = 3
        输出：[
        "((()))",
        "(()())",
        "(())()",
        "()(())",
        "()()()"
        ]*/

public class Test_22 {
//1、暴力
/*        public static List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            generateAll(new char[n*2], 0, result);
            return result;
        }

        public static void generateAll(char[] current, int pos, List<String> result) {
            if(pos == current.length){
                if(valid(current))
                    result.add(new String(current));
                return;
            }else {
                current[pos] = '(';
                generateAll(current, pos+1, result);
                current[pos] = ')';
                generateAll(current, pos+1, result);
            }
        }

        public static boolean valid(char[] current) {
            int f = 0;
            for(char c : current){
                if(c == '(') f++;
                else f--;
                if(f < 0) return false;
            }
            return f == 0;
        }*/
//2、回溯
/*    public static List<String> generateParenthesis(int n){
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    public static void backtrack(List<String> result, StringBuilder sb,
                                 int open, int close, int max){
        if(sb.length() == max*2){
            result.add(sb.toString());
            return;
        }
        if(open < max){
            sb.append('(');
            backtrack(result, sb, open+1, close, max);
            sb.deleteCharAt(sb.length()-1);
        }
        if(open > close){
            sb.append(')');
            backtrack(result, sb, open, close+1, max);
            sb.deleteCharAt(sb.length()-1);
        }
        return;
    }*/

//3、

    public static void main(String[] args) {
//        System.out.println(generateParenthesis(3).toString());
    }


}

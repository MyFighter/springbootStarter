import java.util.ArrayList;
import java.util.List;

public class Test_0809 {
/*    括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。

    说明：解集不能包含重复的子集。

    例如，给出 n = 3，生成结果为：

            [
            "((()))",
            "(()())",
            "(())()",
            "()(())",
            "()()()"
            ]*/

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        int numLeft = 0;
        int numRight = 0;
        dfs(res, "",  numLeft, numRight, n*2);
        return res;
    }

    public static void dfs(List<String> res, String s, int numLeft, int numRight, int total){
        if (s.length() == total){
            res.add(s);
            return;
        }
        if( 2 * numLeft < total)
            dfs(res, s+"(", numLeft+1, numRight, total);
        if( numLeft > numRight)
            dfs(res, s+")", numLeft, numRight+1, total);
    }

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        System.out.println(strings.toString());
    }
}

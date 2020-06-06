package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test_102 {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return result;
        }else{
            queue.add(root);
            List<Integer> subList = new ArrayList<>();
            subList.add(root.value);
            while (!queue.isEmpty()){
                int s = queue.size();
                subList = new ArrayList<>();
                while( s > 0){
                    TreeNode remove = queue.remove();
                    if(remove.left != null)
                        queue.add(remove.left);
                    if(remove.right != null)
                        queue.add(remove.right);
                    subList.add(remove.value);
                    s--;
                }
                result.add(subList);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(t);
        int i = 3;
        int v = t.value;
        while(!queue.isEmpty()){
            int s = queue.size();
            while(s > 0){
                TreeNode remove = queue.remove();
                remove.left = new TreeNode(++v);
                remove.right = new TreeNode(++v);
                queue.add(remove.left);
                queue.add(remove.right);
                s--;
            }
            i--;
            if(i==0)
                break;
        }
        System.out.println(t);
        System.out.println(levelOrder(t).toString());
    }
}

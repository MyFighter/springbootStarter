package Tree;

public class Test_617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1.left!=null || t2.left != null){
            t1.left = t1.left==null?new TreeNode(0):t1.left;
            t2.left = t2.left==null?new TreeNode(0):t2.left;
            t1.left.value = t1.left.value + t2.left.value;
            mergeTrees(t1.left, t2.left);
        }
        if (t1.right!=null || t2.right != null){
            t1.right = t1.right==null?new TreeNode(0):t1.right;
            t2.right = t2.right==null?new TreeNode(0):t2.right;
            t1.right.value = t1.right.value + t2.right.value;
            mergeTrees(t1.right, t2.right);
        }
        return t1;
    }
}

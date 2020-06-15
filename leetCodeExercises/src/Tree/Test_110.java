package Tree;

public class Test_110 {

    public boolean result = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        getDepth(root);
        return result;
    }

    public int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        int ld = getDepth(root.left);
        int rd = getDepth(root.right);
        if (Math.abs(ld - rd) > 1) result=false;
        return Math.max(ld, rd) + 1;
    }

      class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }}
}

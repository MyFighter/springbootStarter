package Tree;

public class Test_437_RE {

    public int total = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return total;
        countPath(root, sum, root.val);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return total;
    }

    public void countPath(TreeNode root, int sum, int curSum) {
        if (curSum == sum) total++;
        if (root == null) return;
        if (root.left != null)
            countPath(root.left, sum, root.left.val+curSum);
        if (root.right != null)
            countPath(root.right, sum, root.right.val+curSum);
    }
}

package Tree;

public class Test_513 {

    public int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int l = diameterOfBinaryTree(root.left);
        int r = diameterOfBinaryTree(root.right);
        diameter = Math.max(diameter, l + r);
        return Math.max(l, r) + 1;
    }
}



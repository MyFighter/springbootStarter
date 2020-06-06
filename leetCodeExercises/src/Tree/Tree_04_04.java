package Tree;

public class Tree_04_04 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if(Math.abs(getDepth(root.left, 0) - getDepth(root.right, 0)) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int getDepth(TreeNode root, int depth){
        if (root == null)
            return depth;
        return Math.max(getDepth(root.left, depth+1),getDepth(root.right, depth+1));
    }

    public static void main(String[] args) {
    }
}



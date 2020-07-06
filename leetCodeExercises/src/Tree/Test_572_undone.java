package Tree;

public class Test_572_undone {

    public static boolean f = true;

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        while (s != null) {
            if (t.val == s.val){
                checkStructure(s, t);
                if(f) {
                    return true;
                }
            }else if (t.val > s.val || s.left.val == s.val) {
                s = s.left;
            }else if (s.right.val == s.val) {
                s = s.right;
            }
        }
        return false;
    }

    public static void checkStructure (TreeNode s, TreeNode t) {
        if (s == t && s == null) {
            return;
        }else if (s.val != t.val) {
            f = false;
            return;
        }
        checkStructure(s.left, t.left);
        checkStructure(s.right, t.right);
    }

    public static void main(String[] args) {

    }
}

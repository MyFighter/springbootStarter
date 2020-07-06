package Tree;

public class Test_572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (s.val == t.val){
            if (checkStructure(s, t)) {
                return true;
            }
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean checkStructure (TreeNode s, TreeNode t) {
        if (s == null && t==null) {
            return true;
        }else if (s==null ^ t==null){
            return false;
        }else if (s.val != t.val) {
            return false;
        }
        return checkStructure(s.left, t.left) && checkStructure(s.right, t.right);
    }

}

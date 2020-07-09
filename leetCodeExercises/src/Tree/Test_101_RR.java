package Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Test_101_RR {
    //我的垃圾方法
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> dequeue = new LinkedList<>();
        dequeue.push(root);
        while (true) {
            if (dequeue.isEmpty()) break;
            TreeNode ln = dequeue.pollFirst();
            TreeNode rn = !dequeue.isEmpty()?dequeue.pollLast():null;
            TreeNode lln = ln.left;
            TreeNode lrn = ln.right;
            if (rn == null) {
                if (lln == null ^ lrn == null) return false;
                else if (lln != null && lrn != null && lln.val!=lrn.val) return false;
                if (ln.left != null) dequeue.push(ln.left);
                if (ln.right != null) dequeue.push(ln.right);
            }else {
                TreeNode rln = rn.left;
                TreeNode rrn = rn.right;
                if ((lln == null ^ rrn == null) || (rln==null ^ lrn==null)) return false;
                else if (lln != null && rrn!=null && (lln.val != rrn.val) ) return false;
                else if (lrn != null && rln!=null && (lrn.val != rln.val)) return false;
                if (ln.right != null) dequeue.push(ln.right);
                if (ln.left != null) dequeue.push(ln.left);
                if (rn.left != null) dequeue.add(rn.left);
                if (rn.right != null) dequeue.add(rn.right);
            }
        }
        return true;
    }

    //递归，加个副本，一个向左下，一个向右下
    public boolean isSymmetric(TreeNode root) {
        return checkSymmetric(root, root);
    }
    public boolean checkSymmetric(TreeNode ln, TreeNode rn) {
        if (ln == null && rn == null) return true;
        if (ln == null || rn == null) return false;
        return ln.val == rn.val && checkSymmetric(ln.left, rn.right) && checkSymmetric(ln.right, rn.left);
    }
    //迭代，加个副本，同理
    public boolean isSymmetric3(TreeNode root) {
        return check(root, root);
    }
    public boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }
}

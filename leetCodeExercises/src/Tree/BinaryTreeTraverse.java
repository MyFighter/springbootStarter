package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTraverse {
    private Node root;
    /**
     * 内部节点类
     * @author yhh
     */
    private class Node{
        private Node left;
        private Node right;
        private int data;
        public Node(int data){
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }
    public BinaryTreeTraverse(){
        root = null;
    }

    /**
     * 递归创建二叉树
     * @param node
     * @param data
     */
    public void buildTree(Node node,int data){
        if(root == null){
            root = new Node(data);
        }else{
            if(data < node.data){
                if(node.left == null){
                    node.left = new Node(data);
                }else{
                    buildTree(node.left,data);
                }
            }else{
                if(node.right == null){
                    node.right = new Node(data);
                }else{
                    buildTree(node.right,data);
                }
            }
        }
    }
    /**
     * 递归前序遍历(深度优先遍历)
     * @param node
     */
    public void preOrder(Node node){
        if(node != null){
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    /**
     * 递归中序遍历
     * @param node
     */
    public void inOrder(Node node){
        if(node != null){
            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.right);
        }
    }
    /**
     * 递归后序遍历
     * @param node
     */
    public void postOrder(Node node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }
    /**
     * 层序遍历
     * @param node
     */
    public void levelOrder(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            Node poll = queue.poll();
            System.out.print(poll.data + " ");
            if(poll.left != null){
                queue.offer(poll.left);
            }
            if(poll.right != null){
                queue.offer(poll.right);
            }
        }
    }
    /**
     * 非递归深度遍历
     * @param node
     */
    public void deepOrder(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            Node pop = stack.pop();
            System.out.print(pop.data + " ");
            if(pop.right != null){
                stack.push(pop.right);
            }
            if(pop.left != null){
                stack.push(pop.left);
            }
        }
    }
    public static void main(String[] args) {
        /**
         *          2
         *        1   4
         *              12
         *             6   45
         *               21  111
         */
        int[] a = {2,1,4,12,45,21,6,111};
//        int[] a = {6, 5, 7, 2, 5, 8};
//        int[] a = {6, 5, 7, 2, 5, 8};
        BinaryTreeTraverse bTree = new BinaryTreeTraverse();
        for (int i = 0; i < a.length; i++) {
            bTree.buildTree(bTree.root, a[i]);
        }
//        System.out.println(bTree.isBalanced(bTree.root));
//        bTree.levelOrder(bTree.root);
        bTree.preOrder(bTree.root);
        System.out.println();
//        System.out.println();
//        bTree.deepOrder(bTree.root);
//        bTree.inOrder(bTree.root);
        bTree.postOrder(bTree.root);
    }



    public boolean isBalanced(Node root) {
        if (root == null)
            return true;
        Node left = root.left;
        Node right = root.right;
        return Math.abs(getDepth(left, 0) - getDepth(right, 0)) < 2;
    }

    public int getDepth(Node root, int depth){
        if (root == null)
            return depth;
        return Math.max(getDepth(root.left, depth+1),getDepth(root.right, depth+1));
    }

}

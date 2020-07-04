package Tree;


import sun.reflect.generics.tree.Tree;

public class Test_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length-1);
    }
    public TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) /2;
        TreeNode midNode = new TreeNode(nums[mid]);
        midNode.left = buildTree(nums, left, mid-1);
        midNode.right = buildTree(nums, mid+1, right);
        return midNode;
    }

    //1,2,3,4
    /*
    *    3
    *   2 4
    *  1   5
    * */
    //1,2,3
    /*
    *       2
    *      1 3
    * */
    // 0 14 7  -> 0 7 3 -> 0 3 1-> 0 1 0
    // 0 10 5 -> 0 5 2 -> 0 2  1-> 0 1 0
    // 0 10 5 -> 6 10 8-> 9 10 9->10 10 10
    // 0
//  -5,-4,-3,-2,-1,0,1,2,3,4,5
    /*
    *                 0
    *          -3          3
    *        -4   -2     1   5
    *       -5      -1    2 4
    * */
    //0 4 1->0 1 0
    public static void main(String[] args) {
        Test_108 t = new Test_108();
        int[] arr = {-10,-3,0,5,9};
        TreeNode node = t.sortedArrayToBST(arr);
        System.out.println(node);
    }
}

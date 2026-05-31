import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class PathSum {
    public static void main(String[] args) {
        System.out.println("PathSum is runnable. Add test cases in main().");
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
        return false;
        if(root.left == null && root.right == null)
            return targetSum == root.val;
        int remaining = targetSum - root.val;

        return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining);
    }
}
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
class MaximumDifferenceBetweenNodeAndAncestor {
    public static void main(String[] args) {
        System.out.println("MaximumDifferenceBetweenNodeAndAncestor is runnable. Add test cases in main().");
    }
    private int dfs(TreeNode node, int min, int max){
        if(node == null)
           return Math.abs(max - min);
        
        min = Math.min(min, node.val);
        max = Math.max(max, node.val);

        return Math.max(dfs(node.left, min, max), dfs(node.right, min, max));
        
    }
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }
}
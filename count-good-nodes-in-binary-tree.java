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
class Solution {
    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }
    public int goodNodes(TreeNode node, int localmax) {
        if(node == null)
            return 0;
        int count = node.val >= localmax ? 1 : 0;
        int newMax = Math.max(localmax, node.val);

        count+=goodNodes(node.left, newMax) + goodNodes(node.right, newMax);
        return count;
    }
}
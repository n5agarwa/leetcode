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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> average = new ArrayList<>();
        if (root == null)
            return average;

        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.offer(root);

        while (!bfs.isEmpty()) {
            int size = bfs.size();
            Double sum = 0.0;

            for (int i = 0; i < size; i++) {
                TreeNode node = bfs.poll();
                sum += node.val;

                if (node.left != null)
                    bfs.offer(node.left);
                if (node.right != null)
                    bfs.offer(node.right);
            }
            average.add(sum/size);
        }
        return average;
    }
}
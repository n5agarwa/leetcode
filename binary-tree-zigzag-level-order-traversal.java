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
class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        System.out.println("BinaryTreeZigzagLevelOrderTraversal is runnable. Add test cases in main().");
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<TreeNode> bfs = new ArrayDeque<>();
        bfs.offer(root);
        boolean flip = false;

        while (!bfs.isEmpty()) {
            int size = bfs.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = bfs.poll();
                if (flip)
                    level.addFirst(node.val);
                else
                    level.addLast(node.val);

                if (node.left != null)
                    bfs.offer(node.left);
                if (node.right != null)
                    bfs.offer(node.right);
            }
            flip = !flip;
            result.add(level);
        }
        return result;
    }

}

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
class BinaryTreeRightSideView {
    public static void main(String[] args) {
        System.out.println("BinaryTreeRightSideView is runnable. Add test cases in main().");
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.offer(root);

        while (!bfs.isEmpty()) {
            int size = bfs.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = bfs.poll();

                if (node.left != null)
                    bfs.offer(node.left);

                if (node.right != null)
                    bfs.offer(node.right);

                if (i == size - 1)
                    result.add(node.val);
            }
        }
        return result;
    }
}
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
    class Pair {
        TreeNode node;
        long index;

        Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        long maxWidth = 0;
        Queue<Pair> bfs = new ArrayDeque<>();

        bfs.offer(new Pair(root, 0));

        while (!bfs.isEmpty()) {

            int size = bfs.size();

            long first = 0, last = 0;

            long normalizingIndex = bfs.peek().index;

            for (int i = 0; i < size; i++) {
                Pair pairnode = bfs.poll();
                long currIndex = pairnode.index - normalizingIndex;

                if (i == 0)
                    first = currIndex;
                if (i == size - 1)
                    last = currIndex;

                if (pairnode.node.left != null) {
                    bfs.offer(new Pair(pairnode.node.left, 2 * currIndex));
                }

                if (pairnode.node.right != null) {
                    bfs.offer(new Pair(pairnode.node.right, 2 * currIndex + 1));

                }

            }
            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return (int) maxWidth;
    }
}
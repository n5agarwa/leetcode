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
    /* BFS version
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
    */
    //DFS version
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> sum = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        List<Double> result = new ArrayList<>();

        dfs(root, 0, sum, count);

        for(int i = 0; i < sum.size(); i++){
            result.add(sum.get(i)/count.get(i));
        }
        return result;
    }

    private void dfs(TreeNode node, int level, List<Double> sum, List<Integer> count) {
        if(node == null) return;

        if(level == sum.size()){
            sum.add((double)node.val); //first time visit node
            count.add(1);
        }
        else{
            sum.set(level, (double)sum.get(level) + node.val);
            count.set(level, count.get(level) + 1);
        }
        dfs(node.left, level + 1, sum, count);
        dfs(node.right, level + 1, sum, count);
    }
}
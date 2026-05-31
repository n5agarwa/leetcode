import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class LowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args) {
        System.out.println("LowestCommonAncestorOfABinarySearchTree is runnable. Add test cases in main().");
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            if(p.val < root.val && q.val < root.val)
                root = root.left;
            else if(p.val > root.val && q.val > root.val)
                root = root.right;
            else
                return root;
        }
        return null;
    }
}
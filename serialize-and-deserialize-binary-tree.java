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
class Codec {
    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        String serialized = codec.serialize(root);
        System.out.println(serialized);
        System.out.println(codec.serialize(codec.deserialize(serialized)));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        serializeDFS(root, sb);
        return sb.toString();
    }

    private void serializeDFS(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");
            return;
        }
        sb.append(node.val).append(",");
        serializeDFS(node.left, sb);
        serializeDFS(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> tokens = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return deserializeDFS(tokens);
    }

    private TreeNode deserializeDFS(Queue<String> tokens) {
        String token = tokens.poll();
        if (token.equals("#"))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(token));
        node.left = deserializeDFS(tokens);
        node.right = deserializeDFS(tokens);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
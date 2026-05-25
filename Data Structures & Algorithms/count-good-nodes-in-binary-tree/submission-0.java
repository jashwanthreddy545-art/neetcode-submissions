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
        AtomicInteger result = new AtomicInteger(0);
        if (root == null) {
            return result.get();
        }
        int max = Integer.MIN_VALUE;
        goodNodes(root, result, max);
        return result.get();
    }

    private void goodNodes(TreeNode node, AtomicInteger result, int max) {
        if (node == null) {
            return;
        }
        if (node.val >= max) {
            result.incrementAndGet();
            max = node.val;
        }
        goodNodes(node.left, result, max);
        goodNodes(node.right, result, max);
    }
}

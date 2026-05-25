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
    public int kthSmallest(TreeNode root, int k) {
        Queue<Integer> queue = new LinkedList<>();
        inOrder(root, queue, k);
        for (int i = 1; i < k; i++) {
            queue.poll();
        }
        return queue.peek();
    }

    private void inOrder(TreeNode root, Queue<Integer> queue, int k) {
        if (root == null) {
            return;
        }
        if (queue.size() == k) {
            return;
        }
        inOrder(root.left, queue, k);
        queue.offer(root.val);
        inOrder(root.right, queue, k);
    }
}

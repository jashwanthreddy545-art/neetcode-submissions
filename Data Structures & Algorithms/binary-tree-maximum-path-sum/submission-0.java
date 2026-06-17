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
    int maxVal = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxVal;
    }

    private int dfs (TreeNode node){
        if (node == null){
            return 0;
        }
        int leftVal = Math.max (0, dfs(node.left));
        int rightVal = Math.max (0, dfs(node.right));

        maxVal = Math.max(maxVal, leftVal + rightVal + node.val);
        return Math.max(leftVal, rightVal)+node.val;
    }
}

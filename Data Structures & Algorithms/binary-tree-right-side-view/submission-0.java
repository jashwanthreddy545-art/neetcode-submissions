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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> levels = new HashSet<>();
        if (root == null) {
            return result;
        }
        rightView(root, 0, result, levels);
        return result;
    }

    private void rightView(TreeNode node, int level, List<Integer> result, Set<Integer> levels) {
        if (node == null) {
            return;
        }
        if (!levels.contains(level)) {
            result.add(node.val);
            levels.add(level);
        }
        rightView(node.right, level+1, result, levels);
        rightView(node.left, level+1, result, levels);
    }
}

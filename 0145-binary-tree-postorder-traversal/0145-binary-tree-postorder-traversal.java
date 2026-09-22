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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }
    
    private void helper(TreeNode node, List<Integer> result) {
        // Base case
        if (node == null) {
            return;
        }
        
        // 1. Traverse left subtree
        helper(node.left, result);
        
        // 2. Traverse right subtree
        helper(node.right, result);
        
        // 3. Visit current node
        result.add(node.val);
    }
}
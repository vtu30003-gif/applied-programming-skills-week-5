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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, "", result);
        return result;
    }
    
    private void dfs(TreeNode node, String currentPath, List<String> result) {
        if (node == null) {
            return;
        }
        
        // Build the current path string
        if (currentPath.isEmpty()) {
            currentPath = String.valueOf(node.val);
        } else {
            currentPath = currentPath + "->" + node.val;
        }
        
        // If it's a leaf node, add the path to the result list
        if (node.left == null && node.right == null) {
            result.add(currentPath);
            return;
        }
        
        // Recursively traverse left and right subtrees
        dfs(node.left, currentPath, result);
        dfs(node.right, currentPath, result);
    }
}
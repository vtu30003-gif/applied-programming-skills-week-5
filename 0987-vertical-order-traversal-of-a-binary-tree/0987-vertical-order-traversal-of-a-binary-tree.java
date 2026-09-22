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
    // Helper class to store node information: column, row, and value
    private static class NodeInfo {
        int col;
        int row;
        int val;

        NodeInfo(int col, int row, int val) {
            this.col = col;
            this.row = row;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<NodeInfo> nodes = new ArrayList<>();
        dfs(root, 0, 0, nodes);

        // Sort nodes: 
        // 1. By column (ascending)
        // 2. By row (ascending)
        // 3. By value (ascending) if column and row are the same
        Collections.sort(nodes, (a, b) -> {
            if (a.col != b.col) {
                return Integer.compare(a.col, b.col);
            } else if (a.row != b.row) {
                return Integer.compare(a.row, b.row);
            } else {
                return Integer.compare(a.val, b.val);
            }
        });

        List<List<Integer>> result = new ArrayList<>();
        if (nodes.isEmpty()) {
            return result;
        }

        int currentCol = -2000; // initialize with an out-of-bounds column value
        List<Integer> currentColumnList = null;

        for (NodeInfo node : nodes) {
            if (node.col != currentCol) {
                currentCol = node.col;
                currentColumnList = new ArrayList<>();
                result.add(currentColumnList);
            }
            currentColumnList.add(node.val);
        }

        return result;
    }

    private void dfs(TreeNode root, int row, int col, List<NodeInfo> nodes) {
        if (root == null) {
            return;
        }
        
        nodes.add(new NodeInfo(col, row, root.val));
        
        // Traverse left child (row + 1, col - 1)
        dfs(root.left, row + 1, col - 1, nodes);
        
        // Traverse right child (row + 1, col + 1)
        dfs(root.right, row + 1, col + 1, nodes);
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return maxDepthHelper(root, 0);
    }
    
    private int maxDepthHelper(TreeNode root, int accumDepth) {
        if(root.left == null && root.right == null) {
            return accumDepth + 1;
        } else {
            if(root.left == null) {
                return 1 + maxDepthHelper(root.right, accumDepth);
            }
            else if(root.right == null) {
                return 1 + maxDepthHelper(root.left, accumDepth);
            }
            else {
                return 1 + Math.max(maxDepthHelper(root.left, accumDepth),
                                    maxDepthHelper(root.right, accumDepth));
            }
        }
    }
}

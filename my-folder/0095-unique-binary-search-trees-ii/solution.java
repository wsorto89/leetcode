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
    public List<TreeNode> generateTrees(int n) {
        if(n < 1) {
            return new ArrayList<TreeNode>();
        }
        return helper(1, n);
    }
    
    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        
        if(start == end) {
            TreeNode root = new TreeNode(start);
            list.add(root);
            return list;
        } else if(start > end) {
            list.add(null);
            return list;
        } else {
            List<TreeNode> left;
            List<TreeNode> right;
            for(int i = start; i <= end; i++) {
                left = helper(start, i - 1);
                right = helper(i + 1, end);
                
                for(TreeNode l : left) {
                    for(TreeNode r : right) {
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        list.add(root);
                    }
                }
            }
            return list;
        }
    }
}

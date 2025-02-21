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
class FindElements {

    TreeNode root;
    public void recover(TreeNode node) {

        if(node.left != null) {
            node.left.val = node.val * 2 + 1;
            recover(node.left);
        }

        if(node.right != null) {
            node.right.val = node.val * 2 + 2;
            recover(node.right);
        }
    }

    public FindElements(TreeNode root) {
        this.root = root;
        this.root.val = 0;
        recover(this.root);
    }

    public boolean search(TreeNode node, int target) {
        
        if(node == null) return false;

        if(node.val == target) return true;

        return search(node.left, target) || search(node.right, target);
    }
    
    public boolean find(int target) {
        return search(this.root, target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
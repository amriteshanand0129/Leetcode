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
    HashSet<Integer> set;
    public void recover(TreeNode node) {

        set.add(node.val);

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
        this.set = new HashSet<>();

        this.root.val = 0;
        recover(this.root);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
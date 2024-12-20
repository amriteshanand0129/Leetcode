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
    public TreeNode reverseOddLevels(TreeNode root) {
        HashMap<Integer, Queue<Integer>> map = new HashMap<>();

        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); queue.add(null);

        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if(node == null) {
                if(!queue.isEmpty()) queue.add(null);
                else break;
                level++;
                continue;
            }

            if(level % 2 != 0) {
                if(map.containsKey(level)) {
                    map.get(level).add(node.val);
                } else {
                    Queue<Integer> q = new LinkedList<>();
                    q.add(node.val);
                    map.put(level, q);
                }
            }
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }

        queue.add(root); queue.add(null);
        level=0;
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if(node == null) {
                if(!queue.isEmpty()) queue.add(null);
                else break;
                level++;
                continue;
            }

            if(level % 2 != 0) {
                node.val = map.get(level).remove();
            }
            if(node.right != null) queue.add(node.right);
            if(node.left != null) queue.add(node.left);
        }

        return root;
    }
}
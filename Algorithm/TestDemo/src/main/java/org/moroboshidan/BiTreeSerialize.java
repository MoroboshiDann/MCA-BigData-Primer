package org.moroboshidan;

import java.util.Deque;
import java.util.LinkedList;


public class BiTreeSerialize {
    public Deque<String> levelSerialize(TreeNode root) {
        Deque<String> ans = new LinkedList<String>();
        if (root == null) return ans;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        ans.offer(root.val + "");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                ans.offer(node.left.val + "");
            } else {
                ans.offer("#");
            }
            if (node.right != null) {
                queue.offer(node.right);
                ans.offer(node.right.val + "");
            } else {
                ans.offer("#");
            }
        }
        return ans;
    }

    public TreeNode levelDeserialize(Deque<String> level) {
        if (level == null || level.isEmpty()) return null;
        String val = level.poll();
        TreeNode root = new TreeNode(Integer.parseInt(val));
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            String left = level.poll();
            if (!"#".equals(left)) {
                root.left = new TreeNode(Integer.parseInt(left));
                queue.offer(root.left);
            }
            String right = level.poll();
            if (!"#".equals(right)) {
                root.right = new TreeNode(Integer.parseInt(right));
                queue.offer(root.right);
            }
        }
        return root;
    }
}

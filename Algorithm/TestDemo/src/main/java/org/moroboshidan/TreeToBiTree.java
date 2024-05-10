package org.moroboshidan;

import java.util.List;

public class TreeToBiTree {
    public TreeNode treeToBiTree(MultiTree root) {
        if (root == null) return null;
        TreeNode treeNode = new TreeNode(root.val);
        treeNode.left = generate(root.children);
        return treeNode;
    }

    private TreeNode generate(List<MultiTree> children) {
        TreeNode root = null;
        TreeNode cur = null;
        for (MultiTree child : children) {
            TreeNode childNode = new TreeNode(child.val);
            if (root == null) {
                root = childNode; // 第一个孩子节点为左子树的根节点
            } else {
                cur.right = childNode;
            }
            cur = childNode;
            cur.left = generate(child.children);
        }
        return root;
    }
}

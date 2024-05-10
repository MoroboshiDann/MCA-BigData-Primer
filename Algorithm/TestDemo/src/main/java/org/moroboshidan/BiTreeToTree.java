package org.moroboshidan;

import java.util.ArrayList;
import java.util.List;

public class BiTreeToTree {
    public MultiTree biTreeToTree(TreeNode root) {
        if (root == null) return null;
        MultiTree multiTree = new MultiTree(root.val);
        multiTree.children = generate(root.left);
        return multiTree;
    }

    private List<MultiTree> generate(TreeNode root) {
        List<MultiTree> children = new ArrayList<>();
        while (root != null) {
            MultiTree cur = new MultiTree(root.val);
            cur.children = generate(root.left);
            children.add(cur);
            root = root.right;
        }
        return children;
    }
}

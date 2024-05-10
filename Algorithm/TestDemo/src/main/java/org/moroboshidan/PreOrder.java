package org.moroboshidan;

import org.moroboshidan.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        TreeNode ptr = root.left;
        ptr.right = new TreeNode(3);
        List<Integer> preorder = preorder(root);
        for (Integer val : preorder) {
            System.out.println(val);
        }
        List<Integer> inorder = inorder(root);
        for (Integer val : inorder) {
            System.out.println(val);
        }
        List<Integer> postorder = postorder(root);
        for (Integer val : postorder) {
            System.out.println(val);
        }
    }

    public static List<Integer> preorder(TreeNode root) {
        // 非递归实现
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return list;
    }

    public static List<Integer> inorder(TreeNode root) {
        // 非递归实现
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }

        return list;
    }

    public static List<Integer> postorder(TreeNode root) {
        // 非递归实现
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        TreeNode ptr = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            if (ptr == root.right || root.right == null) {
                stack.pop();
                list.add(root.val);
                ptr = root;
                root = null;
            } else {
                root = root.right;
            }
        }
        return list;
    }
}

package org.moroboshidan;

import java.util.*;

public class UnionFind {
    private static class Node<T> {
        T val;
        public Node(T val) {
            this.val = val;
        }
        public Node() {}
    }

    private static class UnionSet<T> {
        Map<T, Node<T>> nodes;
        Map<Node<T>, Node<T>> parents;
        Map<Node<T>, Integer> sizes;

        public UnionSet(List<T> values) {
            nodes = new HashMap<>();
            parents = new HashMap<>();
            sizes = new HashMap<>();
            for (T val : values) {
                Node<T> node = new Node<>(val);
                nodes.put(val, node);
                parents.put(node, node);
                sizes.put(node, 1);
            }
        }

        public boolean find(T val1, T val2) {
            Node<T> parent1 = findParent(nodes.get(val1));
            Node<T> parent2 = findParent(nodes.get(val2));
            return parent1 == parent2;
        }

        public void union(T val1, T val2) {
            Node<T> parent1 = findParent(nodes.get(val1));
            Node<T> parent2 = findParent(nodes.get(val2));
            if (parent1 != parent2) {
                int size1 = sizes.get(parent1);
                int size2 = sizes.get(parent2);
                Node<T> greater = size1 > size2 ? parent1 : parent2;
                Node<T> lesser = size1 > size2 ? parent2 : parent1;
                parents.put(lesser, greater);
                sizes.put(greater, size1 + size2);
                sizes.remove(lesser);
            }

        }

        private Node<T> findParent(Node<T> node) {
            Deque<Node<T>> stack = new ArrayDeque<>();
            while (parents.get(node) != node) {
                stack.push(node);
                node = parents.get(node);
            }
            while (!stack.isEmpty()) {
                parents.put(stack.pop(), node);
            }
            return  node;
        }
    }
}

package org.moroboshidan;

public class TrieTree {
    public static class Node {
        public int pass;
        public int end;
        public Node[] nexts;

        public Node() {
            pass = 0;
            end = 0;
            nexts = new Node[26]; // 0...25 分别表示指向a...z的路径
        }
    }

    public static class Trie {
        private Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            if (word == null || word.isEmpty()) return;
            char[] str = word.toCharArray();
            Node node = root;
            node.pass++;
            for (char c : str) {
                int index = c - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new Node();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }

        public int search(String word) {
            if (word == null || word.isEmpty()) return 0;
            char[] str = word.toCharArray();
            Node node = root;
            for (char c : str) {
                int index = c - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        public int startsWith(String prefix) {
            if (prefix == null || prefix.isEmpty()) return 0;
            char[] str = prefix.toCharArray();
            Node node = root;
            for (char c : str) {
                int index = c - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }

        public void delete(String word) {
            if (word == null || word.isEmpty() || search(word) == 0) return;
            char[] str = word.toCharArray();
            Node node = root;
            for (char c : str) {
                int index = c - 'a';
                if (--node.nexts[index].pass == 0) { // 如果路径上某个节点只有一个字符串经过，后续就不用查看了
                    node.nexts[index] = null;
                    return;
                }
                node = node.nexts[index];
            }
            node.end--;
        }
    }
}

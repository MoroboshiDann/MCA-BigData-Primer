package test;

public class Node {
    int key;
    int val;
    Node pre;
    Node post;
    Node() {}
    Node(int key, int val) { this.val = val; pre = null; post = null; }
    Node(int key, int val, Node pre, Node post) {
        this.val = val;
        this.pre = pre;
        this.post = post;
    }
}

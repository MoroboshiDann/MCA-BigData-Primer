package org.moroboshidan;

public class CopyOfRandomLinkedList {
    static class Node {
        int data;
        Node next;
        Node rand;
        public Node(int data) {
            this.data = data;
            this.rand = null;
            this.next = null;
        }
    }

    public Node copyOfRandomLinkedList(Node head) {
        Node current = head;
        Node help = null;
        while (current != null) {
            Node newNode = new Node(current.data);
            help = current.next;
            current.next = newNode;
            newNode.next = help;
            current = help;
        }
        current = head;
        while (current != null) {
            current.next. rand = current.rand.next;
            current = current.next.next;
        }
        current = head;
        Node dummy = new Node(0);
        help = dummy;
        while (current != null) {
            help.next = current.next;
            current.next = help.next;
            help = help.next;
            current = current.next;
        }
        return dummy.next;
    }
}

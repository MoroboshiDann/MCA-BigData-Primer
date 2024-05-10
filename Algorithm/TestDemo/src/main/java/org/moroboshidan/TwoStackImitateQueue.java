package test;

import java.util.Deque;
import java.util.LinkedList;

public class TwoStackImitateQueue {
    private Deque<Integer> pushStack = new LinkedList<>();
    private Deque<Integer> popStack = new LinkedList<>();
    private int size = 0;

    public void offer(int value) {
        pushStack.push(value);
        ++size;
    }

    public int poll() {
        if (size == 0) return -1;
        if (popStack.isEmpty()) reverse();
        --size;
        return popStack.pop();
    }

    private void reverse() {
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
    }
}
package test;

public class Stack {
    class DoubleList {
        private int value;
        private DoubleList pre;
        private DoubleList post;
        public DoubleList() {}
        public DoubleList(int value) {
            this.value = value;
        }
    }

    private int capacity;
    private int size;
    private DoubleList stack;
    private DoubleList top;

    public Stack() {
        this(16);
    }
    public Stack(int capacity) {
        this.capacity = capacity;
        size = 0;
        stack = null;
        top = null;
    } 

    public void push(int value) {
        if (size >= capacity) {
            return;
        }
        DoubleList temp = new DoubleList(value);
        if (stack == null) {
            stack = temp;
            top = temp;
        } else {
            top.post = temp;
            temp.pre = top;
            top = temp;
        }
        ++size;
    }

    public int pop() {
        if (size == 0) return -1;
        DoubleList temp = top;
        if (size == 1) {
            stack = null;
            top = null;
        } else {
            temp = top;
            top = temp.pre;
            top.post = null;
        }
        --size;
        return temp.value;
    }

    public int peek() {
        if (size == 0) return -1;
        return top.value;
    }
}
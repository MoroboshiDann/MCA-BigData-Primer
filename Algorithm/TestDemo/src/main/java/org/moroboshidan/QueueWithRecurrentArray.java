package test;

public class QueueWithRecurrentArray {
    private int[] arr;
    private int head;
    private int rear;
    private int size;
    private int capacity;

    public QueueWithRecurrentArray() {
        this(8);
    }

    public QueueWithRecurrentArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        head = 0;
        rear = -1;
        size = 0;
    }
    
    public void offer(int value) {
        if (size == capacity) return;
        rear = (rear + 1) / capacity;
        arr[rear] = value;
        ++size;
    }

    public int poll() {
        if (size == 0) return -1;
        --size;
        int value = arr[head];
        head = (head + 1) / capacity;
        return value;
    }

    public int getMin() {
        if (size == 0) return -1;
        return 1;
    }
}

package org.moroboshidan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeapSmaller<T> {
    private List<T> heap;
    private Map<T, Integer> map;
    private Comparator<T> comparator;
    private int heapSize;

    public HeapSmaller(Comparator<T> comparator) {
        this.comparator = comparator;
        heap = new ArrayList<T>();
        map = new HashMap<>();
        heapSize = 0;
    }

    public void add(T item) {
        heap.add(item);
        map.put(item, heap.size() - 1);
        upMaintain(heap.size() - 1);
    }

    private void upMaintain(int index) {
        while (comparator.compare(heap.get(index), heap.get((index - 1) >> 1)) < 0) { // compare to the parent node
            swap(index, (index - 1) >> 1);
            index = (index - 1) >> 1;
        }
    }

    private void swap(int i, int j) {
        T o1 = heap.get(i);
        T o2 = heap.get(j);
        heap.set(i, o2);
        heap.set(j, o1);
        map.put(o1, j);
        map.put(o2, i);
    }

    public T poll() {
        swap(0, heap.size() - 1);
        T ans = heap.get(heap.size() - 1);
        map.remove(ans);
        heap.remove(heap.size() - 1);
        downMaintain(0);
        return ans;
    }

    private void downMaintain(int index) {
        int left = (index << 1) + 1;
        while (left < heap.size()) {
            // get the smaller child's index
            int smaller = left + 1 < heap.size() && comparator.compare(heap.get(left), heap.get(left + 1)) < 0 ? left : left + 1;
            smaller = comparator.compare(heap.get(index), heap.get(smaller)) < 0 ? index : smaller;
            if (smaller == index) {
                return;
            }
            swap(index, smaller);
            index = smaller;
            left = (index << 1) + 1;
        }
    }

    public void resign(T item) {
        int index = map.get(item);
        upMaintain(index);  // 修改某个对象的值之后，不知道要上升还是下降，所以先看能不能上升，在看能否下降
        downMaintain(index);
    }

    private void remove(int index) {
        swap(index, heap.size() - 1);
        T ans = heap.get(heap.size() - 1);
        map.remove(ans);
        heap.remove(heap.size() - 1);
        resign(heap.get(index));
    }

    public static void main(String[] args) {

    }
}
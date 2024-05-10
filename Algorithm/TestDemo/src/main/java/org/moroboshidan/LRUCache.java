package test;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    // 一个双向链表用来记录数据
    // 一个hashmap用来映射数据位置
    class LRUCacheImpl {
        private Node head, tail;

        public LRUCacheImpl() {
            head = new Node();
            tail = new Node();
            head.post = tail;
            tail.pre = head;
        }

        public void put(Node target) {
            target.post = this.tail.pre;
            target.pre = this.tail.post;
            this.tail.pre.post = target;
            this.tail.pre = target;
        }

        public Node removeLeastRecently() {
            Node target = head.post;
            head.post = target.post;
            head.post.pre = head;
            return target;
        }

        public void makeRecent(Node target) {
            // 断开
            target.pre.post = target.post;
            target.post.pre = target.pre;
            // 放到尾部
            target.post = this.tail.pre;
            target.pre = this.tail.post;
            this.tail.pre.post = target;
            this.tail.pre = target;
        }
    }

    private LRUCacheImpl cache;
    private Map<Integer, Node> map;
    private int capacity;
    private Node Node;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LRUCacheImpl();
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        cache.makeRecent(map.get(key));
        return map.get(key).val;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            Node target = map.get(key);
            target.val = val;
            cache.makeRecent(target);
            return;
        } else if (map.size() == capacity) {
            Node deletedNode = cache.removeLeastRecently();
            map.remove(deletedNode.key);
        }
        Node target = new Node(key, val);
        cache.put(target);
        map.put(key, target);
    }
}

package org.moroboshidan;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKPrice {
    static class Customer {
        int id;
        int num;
        int enterTime; // 进入某个区域的时间
        
        public Customer() {}
        public Customer(int id) {
            this.id = id;
        }
    }

    HeapSmaller<Customer> pool;
    HeapSmaller<Customer> candidate;
    Map<Integer, Customer> map;

    public List<List<Integer>> winners(int[] customers, boolean[] op, int k) {
        pool = new HeapSmaller<>(new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) { // 得奖区，将购买数量较小的放前面，如果购买数量一致，进入时间早的在前面
                return o1.num != o2.num ? o1.num - o2.num : o1.enterTime - o2.enterTime;
            }
        });
        candidate = new HeapSmaller<>(new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.num != o2.num ? o2.num - o1.num : o2.enterTime - o1.enterTime;
            }
        });
        for (int index : customers) {
            boolean option = op[index];
            Customer customer = map.get(index);
            if (customer == null && !option) {
                continue;
            }
            if (customer == null) {
                customer = new Customer(index);
            }
        }

        return null;
    }
}

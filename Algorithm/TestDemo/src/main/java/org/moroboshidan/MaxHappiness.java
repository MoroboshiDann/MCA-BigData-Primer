package org.moroboshidan;

import com.sun.org.apache.xpath.internal.operations.Mult;

public class MaxHappiness {
    public int maxHappiness(MultiTree root) {
        return process(root, true);
    }

    private int process(MultiTree root, boolean isParentAbsent) {
        if (root == null) return 0;
        int max = 0;
        if (isParentAbsent) { // 父节点不来，当前节点可以选择来或不来
            int sum1= root.val;
            int sum2 = 0;
            for (MultiTree child : root.children) {
                sum1 += process(child, false); // 当前节点来
                sum2 += process(child, true); // 当前节点不来
            }
            max = Math.max(sum1, sum2);
        } else { // 父节点要来，则当前节点只能选择不来
            for (MultiTree child : root.children) {
                max += process(child, true);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MultiTree root = new MultiTree(100);
        MultiTree child1 = new MultiTree(1);
        MultiTree child2 = new MultiTree(2);
        MultiTree child3 = new MultiTree(3);
        root.children.add(child1);
        root.children.add(child2);
        root.children.add(child3);
        MultiTree child4 = new MultiTree(4);
        MultiTree child5 = new MultiTree(5);
        child1.children.add(child4);
        child2.children.add(child5);
        MultiTree child6 = new MultiTree(6);
        MultiTree child7 = new MultiTree(7);
        MultiTree child8 = new MultiTree(8);
        child2.children.add(child6);
        child2.children.add(child7);
        child2.children.add(child8);
        MultiTree child9 = new MultiTree(9);
        MultiTree child10 = new MultiTree(10);
        child3.children.add(child9);
        child3.children.add(child10);
        MultiTree child11 = new MultiTree(99);
        child7.children.add(child11);
        System.out.println(new MaxHappiness().maxHappiness(root));
    }
}

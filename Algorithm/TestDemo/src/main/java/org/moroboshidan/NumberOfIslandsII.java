package org.moroboshidan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfIslandsII {
    private static class UnionFind {
        private int[] parents;
        private int[] sizes;
        private final int row;
        private final int col;
        private int sets;

        public UnionFind(int m, int n) {
            this.row = m;
            this.col = n;
            parents = new int[row * col];
            sizes = new int[row * col];
            for (int i = 0; i < row * col; ++i) {
                parents[i] = i;
                sizes[i] = 0;
            }
        }

        private int findParent(int i, int j) {
            int parent = i * row + j;
            while (parents[parent] != parent) {
                parent = parents[parent];
            }
            return parent;
        }

        public void connect(int i, int j) {
            sizes[i * row + j] = 1;
            ++sets;
            if (i - 1 >= 0) union(i, j, i - 1, j);
            if (i + 1 < row) union(i, j, i + 1, j);
            if (j - 1 >= 0) union(i, j, i, j - 1);
            if (j + 1 < col) union(i, j, i, j + 1);
        }

        public void union(int i, int j, int x, int y) {
            if (sizes[x * row + y] == 0) return;
            int index1 = i * row + j;
            int index2 = x * row + y;
            int parent1 = findParent(i, j);
            int parent2 = findParent(x, y);
            if (parent1 == parent2) return;
            int greater = sizes[index1] > sizes[index2] ? parent1 : parent2;
            int lesser = parent1 == greater ? parent2 : parent1;
            parents[lesser] = greater;
            sizes[greater] = sizes[parent2] + sizes[parent1];
            sizes[lesser] = 0;
            --sets;
        }

        public void firstTime(int i, int j) {
            sizes[i * row + j] = 1;
            ++sets;
        }

        public int nums() {
            return sets;
        }
    }

    public List<Integer> numOfIslands(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        if (positions == null || positions.length == 0) return ans;
        UnionFind union = new UnionFind(m, n);
        union.firstTime(positions[0][0], positions[0][1]);
        ans.add(union.nums());
        for (int i = 1; i < positions.length; ++i) {
            int x = positions[i][0];
            int y = positions[i][1];
            union.connect(x, y);
            ans.add(union.nums());
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> nums = new NumberOfIslandsII().numOfIslands(3, 3, new int[][]{{0, 0}, {0, 1}, {1, 2}, {2, 1}});
        System.out.println(nums);
    }
}

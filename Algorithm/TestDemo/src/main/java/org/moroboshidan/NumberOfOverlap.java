package org.moroboshidan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class NumberOfOverlap {
    public int numberOfOverlap(int[][] segments) {
        // add segments to a list, so that we can sort it by the start index
        List<int[]> lines = new ArrayList<>();
        for (int[] segment : segments) {
            lines.add(segment);
        }
        lines.sort((o1, o2) -> o1[0] - o2[0]); // sort segments
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 0;
        for (int[] line : lines) {
            while (!pq.isEmpty() && pq.peek() < line[0]) { // while the top of the heap is smaller than the start of the current line
                pq.poll(); // get rid of the top
            }
            pq.add(line[1]);
            ans = Math.max(pq.size(), ans);
        } 
        return ans;
    }

    public static void main(String[] args) {

    }
}

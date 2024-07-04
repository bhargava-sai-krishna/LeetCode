import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[k], o1[k]);
            }
        });

        for (int[] row : score) {
            pq.offer(row);
        }

        int index = 0;
        while (!pq.isEmpty()) {
            score[index++] = pq.poll();
        }
        return score;
    }
}

class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        if(n == 1) {
            return stones[0];
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i : stones) {
            heap.offer(i);
        }

        while(heap.size() > 1) {
            heap.offer(heap.poll() - heap.poll());
        }

        return (heap.size() == 0) ? 0 : heap.poll();
    }
}
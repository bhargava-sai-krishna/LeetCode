class Solution {
    public int[] sortByBits(int[] arr) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for(int i : arr) {
            int temp = Integer.bitCount(i);
            if(map.containsKey(temp)) {
                map.get(temp).add(i);
            } else {
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                pq.add(i);
                map.put(temp, pq);
            }
        }

        int i = 0;
        for(Map.Entry<Integer, PriorityQueue<Integer>> e : map.entrySet()) {
            PriorityQueue<Integer> pq = e.getValue();
            while(!pq.isEmpty()) {
                arr[i] = pq.poll();
                i++;
            }
        }

        return arr;
    }
}
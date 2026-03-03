class Solution {
    public int leastInterval(char[] tasks, int n) {
        int cycles = 0;
        int[] frequency = new int[26];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(char task :  tasks) {
            frequency[task - 'A']++;
        }

        for(int i : frequency) {
            if(i > 0) {
                pq.offer(i);
            }
        }

        while(!pq.isEmpty()) {
            List<Integer> remain = new ArrayList<>();
            int currCycles = n + 1; 

            while(currCycles > 0 && !pq.isEmpty()) {
                int maxFreq = pq.poll();
                if(maxFreq > 1) {
                    remain.add(maxFreq - 1);
                }
                cycles++;
                currCycles--;
            }

            for(int count : remain) {
                pq.offer(count);
            }

            if(pq.isEmpty()) {
                break;
            }

            cycles += currCycles;
        }

        return cycles;
    }
}
class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a, b)->b-a);
        for(int n:nums){
            pq.offer(n);
        }
        long scr=0;
        while(!pq.isEmpty() && k>0){
            scr+=pq.peek();
            int x=(int)Math.ceil(pq.poll()/3.0);
            pq.add(x);
            k--;
        }
        return scr;
    }
}
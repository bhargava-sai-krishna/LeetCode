class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<int[]> heap=new PriorityQueue<>((a,b)->b[0]-a[0]);
        int[] freq=new int[26];
        for(char c:s.toCharArray())freq[c-'a']++;
        for(int i=0;i<26;i++)if(freq[i]>0)heap.offer(new int[]{i+'a',freq[i]});
        StringBuilder ans=new StringBuilder();
        while(!heap.isEmpty()){
            int[] top=heap.poll();
            int count=Math.min(top[1],repeatLimit);
            for(int i=0;i<count;i++)ans.append((char)top[0]);
            if(top[1]>count){
                if(heap.isEmpty())break;
                int[] next=heap.poll();
                ans.append((char)next[0]);
                next[1]--;
                if(next[1]>0)heap.offer(next);
                top[1]-=count;
                heap.offer(top);
            }
        }
        return ans.toString();
    }
}
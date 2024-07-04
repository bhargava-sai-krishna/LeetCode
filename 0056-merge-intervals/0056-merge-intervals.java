class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        List<int[]> ans=new ArrayList<>();
        int[] prev=intervals[0];
        for(int i=0;i<intervals.length;i++){
            int[] temp=intervals[i];
            if(temp[0]<=prev[1]){
                prev[1]=Math.max(prev[1],temp[1]);
            }
            else{
                ans.add(prev);
                prev=temp;
            }
        }
        ans.add(prev);
        return ans.toArray(new int[ans.size()][]);
    }
}
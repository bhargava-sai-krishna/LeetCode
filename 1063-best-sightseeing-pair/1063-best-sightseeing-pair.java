class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int ans=0, maxLeft=values[0];
        for(int i=1;i<values.length;i++){
            ans=Math.max(ans, maxLeft+values[i]-i);
            maxLeft=Math.max(maxLeft, values[i]+i);
        }
        return ans;
    }
}
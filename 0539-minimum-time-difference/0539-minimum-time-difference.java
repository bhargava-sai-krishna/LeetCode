class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> mins=new ArrayList<>();
        for(String s: timePoints){
            mins.add((Integer.parseInt(s.substring(0,2))*60)+Integer.parseInt(s.substring(3, 5)));
        }
        Collections.sort(mins);
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<mins.size()-1;i++){
            ans=Math.min(ans, mins.get(i+1)-mins.get(i));
        }
        return Math.min(ans, 1440-mins.get(mins.size()-1)+mins.get(0));
    }
}
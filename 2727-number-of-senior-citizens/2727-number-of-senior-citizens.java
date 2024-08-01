class Solution {
    public int countSeniors(String[] details) {
        int ans=0;
        for(String i:details){
            if(Integer.valueOf(""+i.charAt(11)+i.charAt(12))>60){
                ans++;
            }
        }
        return ans;
    }
}
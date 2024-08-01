class Solution {
    public int countSeniors(String[] details) {
        int ans=0;
        for(String i:details){
            int age=Character.getNumericValue(i.charAt(11))*10+Character.getNumericValue(i.charAt(12));
            if(age>60){
                ans++;
            }
        }
        return ans;
    }
}

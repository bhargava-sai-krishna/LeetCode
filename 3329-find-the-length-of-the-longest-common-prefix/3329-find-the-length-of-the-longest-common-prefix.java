class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<String> a1=new HashSet<>();
        Set<String> a2=new HashSet<>();
        for(int i:arr1){
            String temp=String.valueOf(i);
            for(int j=0;j<temp.length();j++){
                a1.add(temp.substring(0, j));
            }
            a1.add(temp);
        }
        for(int i:arr2){
            String temp=String.valueOf(i);
            for(int j=0;j<temp.length();j++){
                a2.add(temp.substring(0, j));
            }
            a2.add(temp);
        }
        int ans=0;
        for(String i:a2){
            if(a1.contains(i)){
                if(ans<i.length()){
                    ans=i.length();
                }
            }
        }
        return ans;
    }
}
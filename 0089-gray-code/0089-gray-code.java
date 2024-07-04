class Solution {
    public List<Integer> grayCode(int n) {
        if(n==1){
            return new ArrayList<>(Arrays.asList(0, 1));
        }
        List<Integer> code=grayCode(n-1);
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<code.size();i++){
            ans.add(code.get(i));
        }
        for(int i=code.size()-1;i>=0;i--){
            ans.add(code.get(i)+code.size());
        }
        return ans;
    }
}
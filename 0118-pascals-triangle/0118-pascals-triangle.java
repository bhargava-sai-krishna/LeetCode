class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>>ans=new ArrayList();
        if(n==0)return ans;
        List<Integer> first_row=new ArrayList<>();
        first_row.add(1);
        ans.add(first_row);
        for(int i=1;i<n;i++){
            List<Integer> prev=ans.get(i-1);
            List<Integer> curr=new ArrayList<>();
            curr.add(1);
            for(int j=1;j<i;j++){
                curr.add(prev.get(j-1)+prev.get(j));
            }
            curr.add(1);
            ans.add(curr);
        }
        return ans;
    }
}
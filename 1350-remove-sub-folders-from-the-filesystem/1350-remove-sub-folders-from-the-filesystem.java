class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> ans=new ArrayList<>();
        ans.add(folder[0]);
        for(int i=1;i<folder.length;i++){
            String lf=ans.get(ans.size()-1);
            lf+='/';
            if(!folder[i].startsWith(lf)){
                ans.add(folder[i]);
            }
        }
        return ans;
    }
}
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> ans=new ArrayList<>();
        int l=0;
        int r=products.length-1;
        for(int i=0;i<searchWord.length();i++){
            char search=searchWord.charAt(i);
            while(l<=r && (products[l].length()<=i || products[l].charAt(i)!=search)){
                l++;
            }
            while(l<=r && (products[r].length()<=i || products[r].charAt(i)!=search)){
                r--;
            }
            List<String> temp = new ArrayList<>();
            for (int j = l; j <= Math.min(l + 2, r); j++) {
                temp.add(products[j]);
            }
            ans.add(temp);
        }
        return ans;
    }
}
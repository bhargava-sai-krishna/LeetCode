class Solution {
    public String reverseStr(String s, int k) {
        List<String> splits = new ArrayList<>();
        
        for(int i=0;i<s.length();i+=k){
            splits.add(s.substring(i, Math.min(i+k, s.length())));
        }
        
        StringBuilder result = new StringBuilder();
        
        for(int i=0;i<splits.size();i++){
            String part = splits.get(i);
            
            if(i%2==0){
                result.append(new StringBuilder(part).reverse());
            }else{
                result.append(part);
            }
        }
        
        return result.toString();
    }
}
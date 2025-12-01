class Solution {
    public boolean check_palindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;end--;
        }
        return true;
    }
    public void backtrack(String s, int start, List<String> path, List<List<String>> result){
        if(start==s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=start;i<s.length();i++){
            if(check_palindrome(s, start, i)){
                path.add(s.substring(start, i+1));
                backtrack(s, i+1, path, result);
                path.remove(path.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }
}
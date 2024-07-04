class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate("", n, 0, result,0,0);
        return result;
    }
    
    private void generate(String curr, int n, int length, List<String> result,int open,int close) {
        if (length == 2 * n) {
            result.add(curr);
            return;
        }
        if(open<n){
            curr += '(';
            generate(curr, n, length + 1, result,open+1,close);
            curr = curr.substring(0, curr.length() - 1); 
        }

        if(close<open){
            curr += ')';
            generate(curr, n, length + 1, result,open,close+1);
        }
    }
}
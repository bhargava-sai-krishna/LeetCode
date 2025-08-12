class Solution {
    public int longestValidParentheses(String s) {
        int longest=0;
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }
            else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else{
                    longest=Math.max(longest, i-stack.peek());
                }
            }
        }
        return longest;
    }
}
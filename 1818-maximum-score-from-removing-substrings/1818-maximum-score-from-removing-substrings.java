class Solution {
    public int maximumGain(String s, int x, int y) {
        int score=0;
        String highPriority=x>y?"ab":"ba";
        String lowPriority=highPriority.equals("ab")?"ba":"ab";
        String firstPass=removeSubString(s, highPriority);
        int removedPairs=(s.length()-firstPass.length())/2;
        score+=removedPairs*Math.max(x, y);
        String secondPass=removeSubString(firstPass, lowPriority);
        removedPairs=(firstPass.length()-secondPass.length())/2;
        score+=removedPairs*Math.min(x, y);
        return score;
    }
    private String removeSubString(String input, String pair){
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<input.length();i++){
            char curr=input.charAt(i);
            if(curr==pair.charAt(1) && !stack.isEmpty() && stack.peek()==pair.charAt(0)){
                stack.pop();
            }
            else{
                stack.push(curr);
            }
        }
        StringBuilder rem=new StringBuilder();
        while(!stack.isEmpty()){
            rem.append(stack.pop());
        }
        return rem.reverse().toString();
    }
}
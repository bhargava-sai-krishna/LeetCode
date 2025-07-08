class Solution {
    public String simplifyPath(String path) {
        String output="";
        Stack<String> stack=new Stack<>();
        for(String s:path.split("/")){
            if(s.equals("") || s.equals(".")){
                continue;
            }
            else if(s.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{
                stack.push(s);
            }
        }
        for(String s:stack){
            output=output+"/"+s;
        }
        return output.length()==0?"/":output;
    }
}
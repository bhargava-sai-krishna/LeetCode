class Solution {
    private static String performOperation(int a, int b, String operation) {
        return switch(operation) {
            case "+" -> String.valueOf(a + b);
            case "-" -> String.valueOf(a - b);
            case "*" -> String.valueOf(a * b);
            case "/" -> String.valueOf(a / b);
            default -> String.valueOf(a + b);
        };
    } 

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int ans = 0;

        for(String s : tokens) {
            if(!s.equals("+") && 
                !s.equals("-") && 
                !s.equals("*") && 
                !s.equals("/")) {
                stack.push(s);
            } else {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                stack.push(performOperation(b, a, s));
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
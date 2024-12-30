class Solution {
    public static int getPrecedence(char a) {
        if (a == '+' || a == '-') {
            return 1;
        }
        if (a == '*' || a == '/') {
            return 2;
        }
        if (a == '^') {
            return 3;
        }
        return -1;
    }

    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        s = s.replaceAll("\\s+", "");        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                nums.push(num);
            } 
            else if (c == '(') {
                ops.push(c);
            } 
            else if (c == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') {
                    nums.push(applyOp(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.pop();
            } 
            else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                if (c == '-' && (i == 0 || s.charAt(i - 1) == '(')) {
                    nums.push(0);
                }
                while (!ops.isEmpty() && ops.peek() != '(' && getPrecedence(c) <= getPrecedence(ops.peek())) {
                    nums.push(applyOp(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.push(c);
            }
        }
        while (!ops.isEmpty()) {
            nums.push(applyOp(ops.pop(), nums.pop(), nums.pop()));
        }
        
        return nums.pop();
    }

    public int applyOp(char op, int b, int a) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b; 
            case '^': return (int) Math.pow(a, b);
        }
        return 0;
    }
}
class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int n = num1.length();
        int m = num2.length();
        int size = n + m;

        int[] n1 = digits(num1);
        int[] n2 = digits(num2);

        int[] diag = new int[size];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int prod = n1[i] * n2[j];
                diag[i + j] += prod % 10;
                diag[i + j + 1] += prod / 10;
            }
        }

        for(int i = 0; i < size - 1; i++) {
            diag[i + 1] += diag[i] / 10;
            diag[i] %= 10;
        }

        return convertToString(diag, size);
    }

    private int[] digits(String s){
        int len = s.length();
        int[] n = new int[len];

        for(int i = 0; i < len; i++) {
            n[i] = s.charAt(len - 1 - i) - '0';
        }
        
        return n;
    }

    private String convertToString(int[] diag,int n){
        StringBuilder sb = new StringBuilder();

        int i = n - 1;
        while(i > 0 && diag[i] == 0) {
            i--;
        }

        for(; i >= 0; i--) {
            sb.append(diag[i]);
        }
        
        return sb.toString();
    }
}
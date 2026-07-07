class Solution {
    public long sumAndMultiply(int n) {
        long x = 0;
        long sum = 0;
        long multiplier = 1;
        while(n > 0) {
            int d = n % 10;
            if(d != 0) {
                x = d* multiplier + x;
                multiplier *= 10;
                sum += d;
            }
            n /= 10;
        }
        return x * sum;
    }
}
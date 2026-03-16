class Solution {
    public int reverse(int x) {
        int rem = 0;

        while(x != 0) {
            int digit = x % 10;
            if((rem > Integer.MAX_VALUE / 10 || (rem == Integer.MAX_VALUE / 10 && digit > 7)) ||
                (rem < Integer.MIN_VALUE /10 || (rem == Integer.MIN_VALUE / 10 && digit < -8))) {
                    return 0;
                }
            rem *= 10;
            rem += digit;
            x /= 10;
        }

        return rem;
    }
}
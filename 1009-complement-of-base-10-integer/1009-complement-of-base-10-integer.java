class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0) {
            return 1;
        }

        int ans = 0;
        int count = 0;

        while(n > 0) {
            int bit = n % 2;
            n = n >>> 1;

            if(bit == 0) {
                ans += (1 << count);
            }

            count++;
        }

        return ans;
    }
}
class Solution {
    public int arrangeCoins(int n) {
        return (int)Math.floor((Math.sqrt(8l*n + 1) + 1)/2) - 1;
    }
}
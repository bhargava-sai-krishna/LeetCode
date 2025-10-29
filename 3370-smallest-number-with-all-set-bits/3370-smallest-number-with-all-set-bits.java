class Solution {
    public int smallestNumber(int n) {
        return (int)(Math.pow(2, Integer.toBinaryString(n).length())-1.0);
    }
}
class Solution {
    public boolean findColour(String coordinate){
        return ((coordinate.charAt(0)-'a')+(coordinate.charAt(1)-'0'))%2==0;
    }

    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        return findColour(coordinate1)==findColour(coordinate2);
    }
}
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int f = 0;
        int l = numbers.length - 1;
        while (l > f) {
            if (numbers[l] + numbers[f] > target) {
                l--;
            } 
            else if (numbers[l] + numbers[f] < target) {
                f++;
            } 
            else {
                break;
            }
        }
        return new int[]{f + 1, l + 1};
    }
}

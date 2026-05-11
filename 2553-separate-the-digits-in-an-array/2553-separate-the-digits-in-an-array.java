class Solution {
    public int[] separateDigits(int[] nums) {
        return Arrays.stream(nums)
                    .mapToObj(String::valueOf)
                    .flatMapToInt(c -> c.chars().map(s -> s - '0'))
                    .toArray();
    }
}
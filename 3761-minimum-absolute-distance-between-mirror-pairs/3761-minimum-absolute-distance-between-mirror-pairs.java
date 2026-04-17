class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }

            map.get(nums[i]).add(i);
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            int reverse = reverse(nums[i]);
            if(!map.containsKey(reverse)) {
                continue;
            }

            List<Integer> list = map.get(reverse);
            int pos = Collections.binarySearch(list, i + 1);
            if(pos < 0) {
                pos = -pos - 1; 
            }
            
            if(pos < list.size()) {
                ans = Math.min(ans, list.get(pos) - i);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int reverse(int x) {
        boolean neg = x < 0;
        x = Math.abs(x);
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + (x % 10);
            x /= 10;
        }
        return neg ? -rev : rev;
    }
}
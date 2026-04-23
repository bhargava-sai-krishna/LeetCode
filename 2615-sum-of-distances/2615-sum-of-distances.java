class Solution {
    private void computeSum(List<Integer> list, long[] ans) {
        int k = list.size();
        long[] prefix = new long[k];

        prefix[0] = list.get(0);
        for (int i = 1; i < k; i++) {
        prefix[i] = prefix[i - 1] + list.get(i);
        }

        for (int i = 0; i < k; i++) {
            int idx = list.get(i);

            long left = (long) idx * i - (i > 0 ? prefix[i - 1] : 0);
            long right = (prefix[k - 1] - prefix[i]) - (long) idx * (k - i - 1);

            ans[idx] = left + right;
        }
    }

    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }

            map.get(nums[i]).add(i);
        }

        for (List<Integer> list : map.values()) {
            if (list.size() == 1) {
                ans[list.get(0)] = 0;
            } else {
                computeSum(list, ans);
            }
        }

        return ans;
    }
}
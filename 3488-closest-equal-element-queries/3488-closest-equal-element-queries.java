class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }

            map.get(nums[i]).add(i);
        }

        List<Integer> ans = new ArrayList<>();

        for(int query : queries) {
            List<Integer> list = map.get(nums[query]);

            if(list.size() == 1) {
                ans.add(-1);
                continue;
            }

            int ind = binarySearch(list, query);

            int left = (ind - 1 + list.size()) % list.size();
            int right = (ind + 1) % list.size();

            int leftDistance = Math.abs(list.get(ind) - list.get(left));
            int rightDistance = Math.abs(list.get(right) - list.get(ind));

            ans.add(Math.min(
                Math.min(leftDistance, n - leftDistance), 
                Math.min(rightDistance, n - rightDistance)
            ));
        }

        return ans;
    }

    private int binarySearch(List<Integer> list, int query) {
        int low = 0;
        int high = list.size() - 1;

        while(low <= high) {
            int mid = (low + high) >>> 1;

            if(list.get(mid) == query) {
                return mid;
            } else if(list.get(mid) > query) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
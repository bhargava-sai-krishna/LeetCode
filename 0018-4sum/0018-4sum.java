class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                
                long newTarget = (long) target - (long) nums[i] - (long) nums[j];
                
                int low = j + 1, high = n - 1;
                
                while (low < high) {
                    int sum = nums[low] + nums[high];
                    if (sum < newTarget) {
                        low++;
                    } else if (sum > newTarget) {
                        high--;
                    } else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        
                        int temp1 = nums[low];
                        while (low < high && nums[low] == temp1) low++;
                        
                        int temp2 = nums[high];
                        while (low < high && nums[high] == temp2) high--;
                    }
                }
            }
        }
        
        return ans;
    }

}
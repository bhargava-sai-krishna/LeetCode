class FindSumPairs {
    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> count;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1=nums1;
        this.nums2=nums2;
        this.count=new HashMap<>();
        for(int i:nums2){
            count.put(i, count.getOrDefault(i, 0)+1);
        }
    }
    
    public void add(int index, int val) {
        int old=nums2[index];
        count.put(old, count.get(old)-1);
        nums2[index]+=val;
        count.put(nums2[index], count.getOrDefault(nums2[index], 0)+1);
    }
    
    public int count(int tot) {
        int ans=0;
        for(int i:nums1){
            int rest=tot-i;
            ans+=count.getOrDefault(rest, 0);
        }
        return ans;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */
class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int[] ans=new int[nums.length-k+1];
        Map<Integer, Integer>map=new HashMap<>();
        for(int i=0;i<=nums.length-k;i++){
            for(int j=i;j<i+k;j++){
                map.put(nums[j], map.getOrDefault(nums[j], 0)+1);
            }
            List<int[]> freq=new ArrayList<>();
            for(Map.Entry<Integer, Integer> entry:map.entrySet()){
                freq.add(new int[]{entry.getValue(), entry.getKey()});
            }
            freq.sort((a, b)->b[0]!=a[0]?b[0]-a[0]:b[1]-a[1]);
            int x_sum=0;
            for(int j=0;j<x && j<freq.size();j++){
                x_sum+=freq.get(j)[0]*freq.get(j)[1];
            }
            ans[i]=x_sum;
            map.clear();
        }
        return ans;
    }
}
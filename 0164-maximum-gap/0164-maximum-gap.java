class Solution {
    public static void radixSort(int[] nums){
        int max=getMax(nums);
        for(int exp=1;max/exp>0;exp*=10){
            countSort(nums, exp);
        }
    }

    public static int getMax(int[] arr){
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            max=Math.max(arr[i], max);
        }
        return max;
    }

    public static void countSort(int[] arr, int exp){
        int n=arr.length;
        int[] output=new int[n];
        int[] count=new int[10];
        for(int i=0;i<n;i++){
            int digit=(arr[i]/exp)%10;
            count[digit]++;
        }
        for(int i=1;i<10;i++){
            count[i]+=count[i-1];
        }
        for(int i=n-1;i>=0;i--){
            int digit=(arr[i]/exp)%10;
            output[count[digit]-1]=arr[i];
            count[digit]--;
        }
        for(int i=0;i<n;i++){
            arr[i]=output[i];
        }
    }

    public int maximumGap(int[] nums) {
        if(nums.length<2){
            return 0;
        }
        radixSort(nums);
        int max=0;
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            max=Math.max(max, nums[i+1]-nums[i]);
        }
        return max;
    }
}
class Solution {
    public void sortColors(int[] nums) {
        int zer=0, one=0;
        for(int i:nums){
            switch(i){
                case 0:
                    zer++;
                    break;
                case 1:
                    one++;
                    break;
                case 2:
                    break;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(zer!=0){
                nums[i]=0;
                zer--;
            }
            else if(one!=0){
                nums[i]=1;
                one--;
            }
            else{
                nums[i]=2;
            }
        }
    }
}
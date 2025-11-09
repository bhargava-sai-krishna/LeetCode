class Solution {
    public void sortColors(int[] nums) {
        int z=0, o=0;
        for(int i:nums){
            switch(i){
                case 0:
                    z++;
                    break;
                case 1:
                    o++;
                    break;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(z!=0){
                nums[i]=0;
                z--;
            }
            else if(o!=0){
                nums[i]=1;
                o--;
            }
            else{
                nums[i]=2;
            }
        }
    }
}
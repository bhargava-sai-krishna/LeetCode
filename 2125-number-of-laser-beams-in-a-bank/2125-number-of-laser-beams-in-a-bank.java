class Solution {
    public int numberOfBeams(String[] bank) {
        int[] arr=new int[bank.length];
        int k=0;
        int ans=0;
        for(int i=0;i<bank.length;i++){
            int count=0;
            for(char c:bank[i].toCharArray()){
                if(c=='1'){
                    count++;
                }
            }
            if(count>0){
                arr[k]=count;
                k++;
            }
        }
        for(int i=0;i<k-1;i++){
            ans+=arr[i]*arr[i+1];
        }
        return ans;
    }
}
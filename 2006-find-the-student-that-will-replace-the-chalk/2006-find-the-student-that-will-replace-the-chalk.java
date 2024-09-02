class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum=0;
        for(int i:chalk){
            sum=sum+i;
        }
        k=(int)(k%sum);
        for(int i=0;i<chalk.length;i++){
            if(chalk[i]>k){
                return i;
            }
            k=k-chalk[i];
        }
        return 0;
    }
}
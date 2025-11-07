class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n=stations.length;
        long[] count=new long[n+1];
        for(int i=0;i<n;i++){
            int l=Math.max(0, i-r);
            int rt=Math.min(n, i+r+1);
            count[l]+=stations[i];
            count[rt]-=stations[i];
        }
        long lo=Arrays.stream(stations).min().getAsInt();
        long hi=Arrays.stream(stations).asLongStream().sum()+k;
        long res=0;
        while(lo<=hi){
            long mid=lo+(hi-lo)/2;
            if(check(count, mid, r, k)){
                res=mid;
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }
        }
        return res;
    }
    private boolean check(long[] count, long val, int r, int k){
        int n=count.length-1;
        long[] diff=count.clone();
        long sum=0;
        long remaning=k;
        for(int i=0;i<n;i++){
            sum+=diff[i];
            if(sum<val){
                long add=val-sum;
                if(remaning<add){
                    return false;
                }
                remaning-=add;
                int end=Math.min(n, i+2*r+1);
                diff[end]-=add;
                sum+=add;
            }
        }
        return true;
    }
}
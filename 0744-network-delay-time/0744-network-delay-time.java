class Solution {
    public int networkDelayTime(int[][] times, int n, int t) {
        t--;
        int[][] graph=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }
        for(int i=0;i<times.length;i++){
            graph[times[i][0]-1][times[i][1]-1]=times[i][2];
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(graph[i][k]==Integer.MAX_VALUE || graph[k][j]==Integer.MAX_VALUE){
                        continue;
                    }
                    graph[i][j]=Math.min(graph[i][j],graph[i][k]+graph[k][j]);
                }
            }
        }
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(i==t){
                continue;
            }
            if(graph[t][i]==Integer.MAX_VALUE){
                return -1;
            }
            ans=Math.max(ans, graph[t][i]);
        }
        return ans;
    }
}
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] colour=new int[n];
        for(int i=0;i<n;i++){
            if(colour[i]!=0){
                continue;
            }
            Queue<Integer> q=new LinkedList<>();
            q.offer(i);
            colour[i]=1;
            while(!q.isEmpty()){
                int u=q.poll();
                for(int v:graph[u]){
                    if(colour[v]==0){
                        colour[v]=-colour[u];
                        q.offer(v);
                    }
                    else if(colour[v]==colour[u]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
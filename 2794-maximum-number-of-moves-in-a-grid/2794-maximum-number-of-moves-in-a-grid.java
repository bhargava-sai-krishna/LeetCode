class Solution {
    public int maxMoves(int[][] grid) {
        int[][] directions={{-1, 1}, {0, 1}, {1, 1}};
        Queue<int[]> q=new LinkedList<>();
        int m=grid.length, n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            visited[i][0]=true;
            q.offer(new int[]{i, 0, 0});
        }
        int ans=0;
        while(!q.isEmpty()){
            int s=q.size();
            while(s-->0){
                int[] temp=q.poll();
                int row=temp[0], col=temp[1], count=temp[2];
                ans=Math.max(ans, count);
                for(int[] d: directions){
                    int dr=row+d[0], dc=col+d[1];
                    if(dr>=0 && dc>=0 && dr<m && dc<n && !visited[dr][dc] && grid[row][col]<grid[dr][dc]){
                        visited[dr][dc]=true;
                        q.offer(new int[]{dr, dc, count+1});
                    }
                }
            }
        }
        return ans;
    }
}
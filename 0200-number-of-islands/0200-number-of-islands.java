class pair{
    int r, c;
    public pair(int r, int c){
        this.r=r;
        this.c=c;
    }
    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || getClass()!=o.getClass()) return false;
        pair p=(pair)o;
        return r==p.r && c==p.c;
    }
    @Override
    public int hashCode(){
        return Objects.hash(r, c);
    }
}

class Solution {
    public void bfs(char[][] grid, int r, int c, Set<pair> visited, int[][] directions, int rows, int cols){
        Queue<int[]>q=new LinkedList<>();
        visited.add(new pair(r, c));
        q.add(new int[]{r, c});
        while(!q.isEmpty()){
            int[] point=q.poll();
            int row=point[0], col=point[1];
            for(int[] d:directions){
                int nr=row+d[0], nc=col+d[1];
                if(nr>=0 && nr<rows && nc>=0 && nc<cols && grid[nr][nc]=='1' && !visited.contains(new pair(nr, nc))){
                    q.add(new int[]{nr, nc});
                    visited.add(new pair(nr, nc));
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int ans=0;
        Set<pair> visited=new HashSet<>();
        int rows=grid.length, cols=grid[0].length;
        int[][]directions={{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]=='1' && !visited.contains(new pair(r, c))){
                    ans+=1;
                    bfs(grid, r, c, visited, directions, rows, cols);
                }
            }
        }
        return ans;
    }
}
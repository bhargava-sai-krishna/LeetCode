class pair{
    int r, c;
    public pair(int r, int c){
        this.r=r;
        this.c=c;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<pair> rotten=new LinkedList<>();
        int min=0;
        int or=0;
        int rows=grid.length, cols=grid[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                    rotten.offer(new pair(i, j));
                }
                else if(grid[i][j]==1){
                    or++;
                }
            }
        }
        int[][] dir={{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!rotten.isEmpty() && or>0){
            min++;
            int size=rotten.size();
            for(int i=0;i<size;i++){
                pair temp=rotten.removeFirst();
                int r=temp.r, c=temp.c;
                for(int[] d:dir){
                    int row=r+d[0];
                    int col=c+d[1];
                    if(row>=0 && row<rows && col>=0 && col<cols && grid[row][col]==1){
                        or--;
                        grid[row][col]=2;
                        rotten.offer(new pair(row, col));
                    }
                }
            }
        }
        return (or==0)?min:-1;
    }
}
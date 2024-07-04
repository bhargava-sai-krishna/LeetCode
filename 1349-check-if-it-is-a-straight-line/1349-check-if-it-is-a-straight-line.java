class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        boolean ans=true;
        float x0=coordinates[0][0],y0=coordinates[0][1],x1=coordinates[1][0],y1=coordinates[1][1];
        float slope;
        if(x1-x0!=0)
        {
            slope=(y1-y0)/(x1-x0);
            for(int i=2;i<coordinates.length;i++)
            {
                float l=coordinates[i][1]-y1;
                float r=slope*(coordinates[i][0]-x1);
                if(l!=r)
                {
                    ans=false;
                    break;
                }
            }
        }
        else
        {
            for(int i=2;i<coordinates.length;i++)
            {
                if(coordinates[i][0]!=coordinates[0][0])
                {
                    ans=false;
                    break;
                }
            }
        }
        return ans;
    }
}
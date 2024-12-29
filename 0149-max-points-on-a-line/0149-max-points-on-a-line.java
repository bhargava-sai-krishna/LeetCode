class Solution {
    public float slope(int x1, int y1, int x2, int y2) {
        if (x1 == x2) return Float.MAX_VALUE;
        if(y1==y2) return 0;
        return (float) (y2 - y1) / (x2 - x1);
    }
    public int maxPoints(int[][] points) {
        int ans = 1;
        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            Map<Float, Integer> map = new HashMap<>();
            int duplicate = 0;
            int localMax = 0;
            for (int j = i + 1; j < points.length; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                
                if (x1 == x2 && y1 == y2) {
                    duplicate++;
                    continue;
                }
                
                float slope = slope(x1, y1, x2, y2);
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                localMax = Math.max(localMax, map.get(slope));
            }
            ans = Math.max(ans, localMax + duplicate + 1);
        }
        return ans;
    }
}

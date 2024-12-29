import java.util.*;

class Solution {
    public int maxPoints(int[][] points) {
        int ans = 1;
        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            Map<String, Integer> map = new HashMap<>();
            int duplicate = 0;
            int localMax = 0;
            for (int j = i + 1; j < points.length; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];

                if (x1 == x2 && y1 == y2) {
                    duplicate++;
                    continue;
                }

                int dx = x2 - x1;
                int dy = y2 - y1;
                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;

                // Ensure consistent slope representation
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                } else if (dx == 0) {
                    dy = Math.abs(dy); // Vertical line
                }

                String slope = dx + "," + dy; // Represent slope as "dx,dy"
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                localMax = Math.max(localMax, map.get(slope));
            }
            ans = Math.max(ans, localMax + duplicate + 1);
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}

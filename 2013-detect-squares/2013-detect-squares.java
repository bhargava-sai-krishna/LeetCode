class DetectSquares {

    List<int[]> points; 
    Map<String, Integer> counts;

    public DetectSquares() {
        points = new ArrayList<>();
        counts = new HashMap<>();
    }
    
    public void add(int[] point) {
        points.add(point);
        String key = computeKey(point[0], point[1]);
        counts.put(key, counts.getOrDefault(key, 0) + 1);
    }
    
    public int count(int[] pt) {
        int sum = 0, px = pt[0], py = pt[1];

        for(int[] point :  points) {
            int x = point[0], y = point[1];

            if(x == px || y == py || Math.abs(px - x) != Math.abs(py - y)) {
                continue;
            }

            sum += counts.getOrDefault(computeKey(x, py), 0) * counts.getOrDefault(computeKey(px, y), 0);
        }

        return sum;
    }

    private String computeKey(int x, int y) {
        return x + "#" + y;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
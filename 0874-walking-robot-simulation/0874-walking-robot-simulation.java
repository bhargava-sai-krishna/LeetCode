class Solution {
    private static final long HASH_MULTIPLIER = 60013;
    private static final int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private long hashCoordinates(int x, int y) {
        return y + HASH_MULTIPLIER * x;
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Long> set = new HashSet<>();
        for(int[] coor : obstacles) {
            set.add(hashCoordinates(coor[0], coor[1]));
        }

        int[] curr = {0, 0};
        int maxDistance = 0;
        int currDirection = 0;

        for(int command : commands) {
            if(command == -1) {
                currDirection = (currDirection + 1) % 4;
                continue;
            } else if(command  == -2) {
                currDirection = (currDirection + 3) % 4;
                continue;
            }

            int[] direction = dir[currDirection];

            for(int step = 0; step < command; step++) {
                int nxtX = curr[0] + direction[0];
                int nxtY = curr[1] + direction[1];

                if(set.contains(hashCoordinates(nxtX, nxtY))) {
                    break;
                }

                curr[0] = nxtX; 
                curr[1] = nxtY;
            }

            maxDistance = Math.max(maxDistance, 
                        curr[0] * curr[0] + curr[1] * curr[1]
            );
        }

        return maxDistance;
    }
}
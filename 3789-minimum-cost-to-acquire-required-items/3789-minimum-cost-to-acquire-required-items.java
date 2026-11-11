
class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {

        long individual = (long) cost1 * need1
                        + (long) cost2 * need2;

        long both = (long) Math.max(need1, need2) * costBoth;

        long mixed = (long) Math.min(need1, need2) * costBoth;

        if (need1 > need2) {
            mixed += (long) (need1 - need2) * cost1;
        } else {
            mixed += (long) (need2 - need1) * cost2;
        }

        return Math.min(individual, Math.min(both, mixed));
    }
}

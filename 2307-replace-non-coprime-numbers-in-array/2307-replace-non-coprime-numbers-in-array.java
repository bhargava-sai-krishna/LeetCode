class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            result.add(num);
            while (result.size() >= 2) {
                int last = result.get(result.size() - 1);
                int secondLast = result.get(result.size() - 2);
                if (gcd(last, secondLast) > 1) {
                    result.remove(result.size() - 1); // Remove last
                    result.remove(result.size() - 1); // Remove second last
                    result.add(lcm(last, secondLast)); // Add LCM
                } else {
                    break; // No more replacements can be made
                }
            }
        }
        return result;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private int lcm(int a, int b) {
        return a / gcd(a, b) * b; // Calculate LCM
    }
}
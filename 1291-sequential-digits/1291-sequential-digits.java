class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();

        String digits = "123456789";

        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();

        for (int len = lowLen; len <= highLen; len++) {

            int p = 0;
            int q = len - 1;

            while (q < digits.length()) {
                int num = Integer.parseInt(digits.substring(p, q + 1));

                if (num >= low && num <= high) {
                    ans.add(num);
                }

                p++;
                q++;
            }
        }

        return ans;
    }
}
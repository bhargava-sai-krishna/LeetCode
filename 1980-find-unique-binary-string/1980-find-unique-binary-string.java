class Solution {
    private String makeToSutialbleLength(String s, int n) {
        if(s.length() == n) {
            return s;
        }

        while(s.length() != n) {
            s += "0";
        }

        return s;
    }

    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        int maxPossibleNumber = (int)Math.pow(2, n) - 1;
        Set<String> set = new HashSet<>();

        for(String s : nums) {
            set.add(s);
        }

        for(int i = 0; i <= maxPossibleNumber; i++) {
            String s = makeToSutialbleLength(Integer.toBinaryString(i), n);;
            
            if(!set.contains(s)) {
                return s;
            }
        }

        return new String();
    }
}
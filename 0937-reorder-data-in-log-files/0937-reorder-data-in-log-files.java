class Solution {
    public String[] reorderLogFiles(String[] logs) {
        int n = logs.length;
        String[] ans = new String[n];
        Queue<String> digitLogs = new LinkedList<>();
        PriorityQueue<String> letterLogs=new PriorityQueue<>((a,b)->{
            int aIdx=a.indexOf(' ');
            int bIdx=b.indexOf(' ');

            String aId=a.substring(0, aIdx);
            String bId=b.substring(0, bIdx);

            String aContent=a.substring(aIdx + 1);
            String bContent=b.substring(bIdx + 1);

            int cmp=aContent.compareTo(bContent);
            if(cmp != 0) {
                return cmp;
            }
            return aId.compareTo(bId);
        });
        for(String str : logs) {
            if(Character.isDigit(
                    str.substring(
                            str.indexOf(' ') + 1).charAt(0))) {
                digitLogs.add(str);
            } else {
                letterLogs.add(str);
            }
        }
        for(int i = 0; i < n; i++) {
            if(!letterLogs.isEmpty()) {
                ans[i] = letterLogs.poll();
            } else {
                ans[i] = digitLogs.poll();
            }
        }
        
        return ans;
    }
}
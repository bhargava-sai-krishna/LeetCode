class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskGroup=new int[26];
        int max=0;
        int maxCount=0;
        for(char c:tasks){
            taskGroup[c-'A']+=1;
            if(max==taskGroup[c-'A']){
                maxCount++;
            }
            else if(max<taskGroup[c-'A']){
                max=taskGroup[c-'A'];
                maxCount=1;
            }
        }
        int partCount=max-1;
        int partLength=n-(maxCount-1);
        int emptySlots=partCount*partLength;
        int avaliable=tasks.length-max*maxCount;
        int idl=Math.max(0, emptySlots-avaliable);
        return tasks.length+idl;
    }
}
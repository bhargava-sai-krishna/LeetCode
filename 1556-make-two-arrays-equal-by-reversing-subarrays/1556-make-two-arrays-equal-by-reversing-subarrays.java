class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        if(target.length!=arr.length){
            return false;
        }
        for(int i=0;i<arr.length;i++){
            if(target[i]!=arr[i]){
                return false;
            }
        }
        return true;
    }
}
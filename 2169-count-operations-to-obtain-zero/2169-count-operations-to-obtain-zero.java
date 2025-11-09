class Solution {
    public int helper(int n1, int n2, int count){
        if(n1==0 || n2==0){
            return count;
        }
        if(n1>=n2){
            n1-=n2;
        }
        else{
            n2-=n1;
        }
        return helper(n1, n2, ++count);
    }
    public int countOperations(int num1, int num2) {
        int count=0;
        return helper(num1, num2, count);
    }
}
class Solution {
    public char kthCharacter(int k) {
        return dfs(getLevel(0, k), k);
    }
    public int getLevel(int level, int k){
        if((1<<level)>=k){
            return level;
        }
        return getLevel(level+1, k);
    }
    public char dfs(int level, int k){
        if(level==0){
            return 'a';
        }
        int half=1<<(level-1);
        if(k<=half){
            return dfs(level-1, k);
        }
        else{
            char c=dfs(level-1, k-half);
            return (char)(c+1);
        }
    }
}
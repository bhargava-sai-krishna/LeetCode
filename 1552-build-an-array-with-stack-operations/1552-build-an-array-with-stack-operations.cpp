class Solution {
public:
    vector<string> buildArray(vector<int>& target, int n) {
        vector<string> output;
        int l=(int)target.size();
        stack<int> st;
        int track=0;
        for(int i=1;i<=n;i++ ){
            st.push(i);
            output.push_back("Push");
            if(st.top()==target[l-1]){
                break;
            }
            if(i==target[track]){
                track+=1;
            }
            else{
                st.pop();
                output.push_back("Pop");
            }
        }
    return output;
    }
};
#include<algorithm>
#include<vector>
using namespace std;
class Solution {
public:
    vector<vector<int>> reconstructQueue(vector<vector<int>>& people) {
        vector<vector<int>> ans;

        sort(people.begin(), people.end(), [](const auto& a, const auto& b) {
        return a[0] == b[0] ? a[1] < b[1] : a[0] > b[0];
        });
        
        for (const vector<int>& p : people)
        ans.insert(begin(ans) + p[1], p);

        return ans;
  }
};
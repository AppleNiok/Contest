#include <string>

class Solution{
    public:
        int longestContinuousSubstring(string s){
            int ans = 0;
            int cur = 0;
            for(int i = 0;i<s.size();i++){
                if(!i || s[i]!=s[i]+1)
                    cur = 0;
                cur++;
                ans = max(res,cur);
            }
            return res;
        }
};
class Solution{
    public:
        vector<int> sumPrefixScores(vector<string>& words){
            vector<ar<int,26>> c(1);
            vector<int> cnt(1);
            int n = 1;
            for(auto x : words){
                int u = 0;
                for(char ch : x){
                    if(!c[u][ch-'a']){
                        c[u][ch-'a'] = n++;
                        c.push_back({});
                        cnt.push_back(0);
                    }
                    u = c[u][ch-'a'];
                    ++cnt[u];
                }
            }
            vector<int> ans;
            for(auto x : words){
                int u = 0;
                int cur = 0;
                for(char ch : x){
                    u = c[u][ch - 'a'];
                    cur += cnt[u];
                }
                ans.push_back(cur);
            }
            return ans;
        }
};
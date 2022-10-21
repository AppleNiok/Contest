class Solution {
public:
    int edgeScore(vector<int>& a) {
        int n = a.size();
        vector<long,long> cnt(n + 1);
        long long mx = -1, res = -1;
        for(int i = 0; i < a.size(); i++) {
            cnt[a[i]] += i;
        }
        for(int i = 0; i < cnt.size(); i++){ 
            if(cnt[i] > mx) {
                mx = cnt[i]; res = i;
            }
        }
        return res;
    }
};
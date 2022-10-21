
class Three {
public:
    int minimizeXor(int num1, int num2) {
        int ans = 0;
        int cnt = __builtin_popcount(num2);
        for (int i = 30; i >= 0 && cnt; --i) {
            if (num1 & (1 << i)) {
                ans ^= (1 << i);
                --cnt;
            }
        }
        for (int i = 0; i <= 30 && cnt; ++i) {
            if (!(num1 & (1 << i))) {
                ans ^= (1 << i);
                --cnt;
            }
        }
        return ans;
    }
};

class Four {
public:
    int deleteString(string s) {
        int n = s.size();
        vector lcp(n, vector<int>(n));
        for (int i = n - 1; i >= 0; i -= 1)
            for (int j = n - 1; j >= 0; j -= 1) {
                if (s[i] == s[j]) {
                    lcp[i][j] = 1;
                    if (i + 1 < n and j + 1 < n)
                        lcp[i][j] += lcp[i + 1][j + 1];
                }
            }
        vector<int> dp(n + 1);
        for (int i = n - 1; i >= 0; i -= 1) {
            dp[i] = 1;
            for (int j = 1; j <= (n - i) / 2; j += 1) {
                if (lcp[i][i + j] >= j) {
                    dp[i] = max(dp[i], dp[i + j] + 1);
                }
            }
        }
        return dp[0];
    }
};
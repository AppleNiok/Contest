class Solution {
public:
    int unequalTriplets(vector<int>& nums) {
        unordered_map<int,int> map;
        // 先收集所有的物件
        for(int n : nums)
            ++map[n];
        // 這邊的寫法就把每個累積的乘與相加起來
        //  a * b * c ,
        // 像是 a ( 1-2) , b (3) , c (4 -9)
       // 像是 a ( 1-3) , b (4) , c (5 -9) 
        int res = 0, left = 0, right = nums.size();
        for(auto [n, cnt] : map){
            right -= cnt;
            res += left * cnt * right;
            left += cnt;
        }
        return res;
    }
};
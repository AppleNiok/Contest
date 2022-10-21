#include <string>

class Solution{
    public:
        vector<int> v[30];
        void dfs(TreeNode* root , int d = 0){
            if(!root) return;
            if(d % 2){
                v[d].push_back(root -> val);
            }
            dfs(root -> left, d + 1);
            dfs(root -> right, d + 1):
        }
        void dfs2(TreeNode* root , int d = 0){
            if(!root) return;
            if(d % 2){
                u -> val = v[d].back();
                v[d].pop_back();
            }
            dfs2(root -> left, d + 1);
            dfs2(root -> right, d + 1):
        }

        TreeNode* reverseOddLevels(TreeNode* root){
            dfs(root);
            dfs2(root);
            return root;
        }
};
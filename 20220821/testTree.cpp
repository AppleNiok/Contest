/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
    int mx = 0;
    vector<vector<int>> e;

    void dfs1(TreeNode *node) {
        if (node == nullptr) return;
        mx = max(mx, node->val);
        dfs1(node->left); dfs1(node->right);
    }

    void dfs2(TreeNode *node) {
        if (node->left != nullptr) {
            e[node->val].push_back(node->left->val);
            e[node->left->val].push_back(node->val);
            dfs2(node->left);
        }
        if (node->right != nullptr) {
            e[node->val].push_back(node->right->val);
            e[node->right->val].push_back(node->val);
            dfs2(node->right);
        }
    }

    int dfs3(int sn, int fa) {
        int ret = 0;
        for (int fn : e[sn]) if (fn != fa) ret = max(ret, dfs3(fn, sn) + 1);
        return ret;
    }

public:
    int amountOfTime(TreeNode* root, int start) {
        dfs1(root);
        e.resize(mx + 1);
        dfs2(root);
        return dfs3(start, -1);
    }
};
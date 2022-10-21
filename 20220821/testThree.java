public class testThree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    public int amountOfTime(TreeNode root, int start) {
        Node node = findNode(rebuild(root), null, start);
        return maxDepth(node, null, 0);
    }

    public int maxDepth(Node root, Node p, int depth) {
        int ans = depth;
        for (Node node : root.adj) {
            if (node == p) {
                continue;
            }
            ans = Math.max(ans, maxDepth(node, root, depth + 1));
        }
        return ans;
    }

    public Node findNode(Node root, Node p, int val) {
        if (root.val == val) {
            return root;
        }
        for (Node node : root.adj) {
            if (node == p) {
                continue;
            }
            Node ans = findNode(node, root, val);
            if (ans != null) {
                return ans;
            }
        }
        return null;
    }

    public void addEdge(Node a, Node b) {
        if (a == null || b == null) {
            return;
        }
        a.adj.add(b);
        b.adj.add(a);
    }

    public Node rebuild(TreeNode root) {
        if (root == null) {
            return null;
        }
        Node node = new Node();
        node.val = root.val;
        addEdge(rebuild(root.left), node);
        addEdge(rebuild(root.right), node);
        return node;
    }

    class Node {
        List<Node> adj = new ArrayList();
        int val;
    }
}

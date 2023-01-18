/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        recursive(list, root);
        return list;
    }
    
    private void recursive(final List<Integer> list, Node root) {
        if (root == null) return;
        list.add(root.val);
        if (root.children == null) return;
        for (Node node: root.children) {
            recursive(list, node);
        }
    }
}
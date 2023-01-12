/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    //구 노드, 구 이웃
    Map<Node, List<Node>> connectMap = new HashMap<>();
    
    //구 노드, 신 노드
    Map<Node, Node> nodeMap = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        
        recursive(node);
        setRecursive(node);
        
        return nodeMap.get(node);
    }
    
    private void recursive(Node node) {
        if (connectMap.containsKey(node)) {
            return;
        }
        
        connectMap.put(node, node.neighbors);
        nodeMap.put(node, new Node(node.val));
        for (Node n: node.neighbors) {
            recursive(n);
        }
    }
    
    private void setRecursive(Node node) {
        Iterator<Node> iter = nodeMap.keySet().iterator();
        while(iter.hasNext()) {
            Node preNode = iter.next();
            List<Node> preNodes = connectMap.get(preNode);
            nodeMap.get(preNode).neighbors.addAll(preNodes.stream()
                .map(v -> nodeMap.get(v))
                .collect(Collectors.toList()));
        }
    }
}
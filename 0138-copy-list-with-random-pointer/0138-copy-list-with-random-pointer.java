/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        Node copyParentNode = null;
        Node copyCurrentNode = null;
        Node parentNode = head;
        Node currentNode = head;
        
        //구 노드, 구 노드의 랜덤
        Map<Node, Node> historyMap = new HashMap<>();
        
        //구 노드, 신 노드
        Map<Node, Node> newHistoryMap = new HashMap<>();
        
        while(currentNode != null) {
            //구 노드
            historyMap.put(currentNode, currentNode.random);
            
            Node key = currentNode;
            
            if (copyParentNode == null) {
                copyParentNode = new Node(currentNode.val);
                copyCurrentNode = copyParentNode;
            } else {
                Node newNode = new Node(currentNode.val);
                copyCurrentNode.next = newNode;
                copyCurrentNode = copyCurrentNode.next;
            }
            newHistoryMap.put(key, copyCurrentNode);
            currentNode = currentNode.next;
        }
        
        Iterator<Node> iter = newHistoryMap.keySet().iterator();
        while(iter.hasNext()) {
            Node preNode = iter.next();
            Node preRandomNode = historyMap.get(preNode);
            Node newNode = newHistoryMap.get(preNode);
            newNode.random = newHistoryMap.get(preRandomNode);
        }
        
        
        return copyParentNode;
    }
}
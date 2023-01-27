class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int a: stones) {
            queue.add(a);
        }
        
        while(queue.size() != 1) {
            queue.add(Math.abs(queue.poll() - queue.poll()));
        }
        
        return queue.poll();
    }
}
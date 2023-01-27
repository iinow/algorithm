class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stackA = new Stack<>();
        Stack<Character> stackB = new Stack<>();
        
        for (char c: s.toCharArray()) {
            if (c == '#') {
                if (!stackA.isEmpty()) stackA.pop();
            } else {
                stackA.push(c);
            }
        }
        
        for (char c: t.toCharArray()) {
            if (c == '#') {
                if (!stackB.isEmpty()) stackB.pop();
            } else {
                stackB.push(c);
            }
        }
        
        return stackA.toString().equals(stackB.toString());
    }
}
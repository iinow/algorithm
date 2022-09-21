class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            char data = stack.pop();
            if (data == '(' && ch == ')') {
                continue;
            }

            if (data == '{' && ch == '}') {
                continue;
            }

            if (data == '[' && ch == ']') {
                continue;
            }

            return false;
        }
        return stack.isEmpty();
    }
}
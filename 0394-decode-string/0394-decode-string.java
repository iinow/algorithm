class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != ']') {
                stack.push(String.valueOf(c));
                continue;
            }

            String message = "";
            while (!stack.isEmpty()) {
                String v = stack.pop();
                if (v.equals("[")) {
                    break;
                }
                message = v + message;
            }

            // digit
            String countString = "";
            while (!stack.isEmpty()) {
                if (!stack.peek().matches("\\d")) {
                    break;
                }

                countString = stack.pop() + countString;
            }

            String res = "";
            for (int i = 0; i < Integer.valueOf(countString); i++) {
                res += message;
            }

            stack.push(res);
        }

        return String.join("", stack);
    }
}
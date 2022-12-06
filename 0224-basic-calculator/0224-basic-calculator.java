class Solution {
    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        char[] chars = s.replaceAll("\\s", "").toCharArray();

        String value = "";
        for (char c: chars) {
            if (c == ')') {
                if (value.length() != 0) {
                    stack.push(value);
                    value = "";
                }
                stack.push(String.valueOf(calc(stack)));
            } else if (c == '(') {
                if (value.length() != 0) {
                    stack.push(value);
                    value = "";
                }
                stack.push(String.valueOf(c));
            } else if (c == '+') {
                if (value.length() != 0) {
                    stack.push(value);
                    value = "";
                }
                stack.push(String.valueOf(c));
            } else if (c == '-') {
                if (value.length() != 0) {
                    stack.push(value);
                    value = "";
                }
                stack.push(String.valueOf(c));
            } else {
                value += String.valueOf(c);
            }
        }
        if (value.length() != 0) {
            stack.push(value);
        }

        return calc(stack);
    }

    private int calc(Stack<String> stack) {
        int previousValue = 0;
        int sum = 0;
        while(!stack.isEmpty()) {
            String op = stack.pop();
            if (op.equals("+")) {
                sum += previousValue;
                previousValue = 0;
            } else if (op.equals("-")) {
                previousValue = previousValue * -1;
                sum += previousValue;
                previousValue = 0;
            } else if (op.equals("(")) {
                break;
            } else {
                previousValue = Integer.parseInt(op);
            }
        }
        if (previousValue != 0) {
            sum += previousValue;
        }
        return sum;
    }
}
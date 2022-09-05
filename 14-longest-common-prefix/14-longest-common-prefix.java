import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Stream;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        Stack<String> stack = new Stack<>();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            min = Math.min(min, strs[i].length());
        }

        if (min == 0) {
            return "";
        }

        while (min > 0) {
            for (int i = 0; i < strs.length; i++) {
                if (strs.length == 0) {
                    break;
                }
                String str = strs[i].substring(0, 1);
                if (str.length() == 0) {
                    break;
                }
                if (i == 0) {
                    stack.push(str);
                } else {
                    if (!stack.peek().equals(str)) {
                        stack.pop();
                        min = -1;
                        break;
                    }
                }
                strs[i] = strs[i].substring(1, strs[i].length());
            }
            min--;
        }

        return String.join("", stack);
    }
}
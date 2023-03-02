import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Stream;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        char[] cs = new char[201];
        char[] first = strs[0].toCharArray();
        for (int i = 0; i < first.length; i++) {
            cs[i] = first[i];
        }
        for (int i = 1; i < strs.length; i++) {
            char[] scs = strs[i].toCharArray();
            for (int j = 0; j < scs.length; j++) {
                if (cs[j] == 0 || cs[j] != scs[j]) {
                    cs[j] = 0;
                    break;
                }
            }
            if (first.length > scs.length) {
                cs[scs.length] = 0;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (char c: cs) {
            if (c == 0) {
                break;
            }
            builder.append(c);
        }
        return builder.toString();
    }
}
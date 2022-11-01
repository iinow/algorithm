import java.util.*;

class Solution {
    Boolean[] mem = null;
    public boolean wordBreak(String s, List<String> wordDict) {
        mem = new Boolean[s.length() + 1];
        return recursive(0, s, new HashSet<String>(wordDict));
    }
    
    private boolean recursive(int index, String s, final Set<String> words) {
        if (mem[index] != null && !mem[index]) {
            return false;
        }
        
        if (s.length() == index) {
            return mem[index] = true;
        }
        
        for (int i = index + 1; i < s.length() + 1; i++) {
            if (words.contains(s.substring(index, i)) && recursive(i, s, words)) {
                return mem[index] = true;
            }
        }
        return mem[index] = false;
    }
}
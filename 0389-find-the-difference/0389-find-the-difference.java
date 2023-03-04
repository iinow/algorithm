class Solution {
    public char findTheDifference(String s, String t) {
        int[] cs = new int[26];
        char[] scs = s.toCharArray();
        char[] tcs = t.toCharArray();
        for (int i = 0; i < scs.length; i++) {
            cs[scs[i] - 'a']++;
        }
        
        for (int i = 0; i < tcs.length; i++) {
            cs[tcs[i] - 'a']--;
        }
        
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == -1) return (char)(i + 'a');
        }
        return 0;
    }
}
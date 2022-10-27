class Solution {
    public void reverseString(char[] s) {
        char[] copys = new char[s.length];
        for(int i = 0; i < s.length; i++) {
            copys[i] = s[i];
        }
        
        for (int i = copys.length - 1; i >= 0; i--) {
            s[Math.abs(i - (copys.length - 1))] = copys[i];
        }
    }
}
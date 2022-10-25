class Solution {
    public boolean isIsomorphic(String s, String t) {
        int length = s.length();
        for (int i = 0; i < length; i++) {
            boolean res = s.indexOf(s.substring(i, i + 1)) == t.indexOf(t.substring(i, i + 1));
            if (!res) {
                return false;
            }
        }
        return true;
    }
}
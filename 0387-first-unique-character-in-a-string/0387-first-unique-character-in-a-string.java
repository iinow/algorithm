class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> tree = new LinkedHashMap<>();
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (s.lastIndexOf(cs[i]) == i && s.indexOf(cs[i]) == i) {
                return i;
            }
        }
        return -1;
    }
}
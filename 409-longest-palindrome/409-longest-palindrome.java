class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        int remove = set.size();
        if (remove > 0) {
            remove -= 1;
        }

        return s.length() - remove;
    }
}
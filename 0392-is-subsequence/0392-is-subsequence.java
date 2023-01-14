class Solution {
    public boolean isSubsequence(String s, String t) {
        String[] strs = s.split("");

        for (String str : strs) {
            int index = t.indexOf(str);
            if (index == -1)
                return false;

            if (t.length() - 1 < index + 1) {
                t = "";
                continue;
            }
            t = t.substring(index + 1);
        }

        return true;
    }
}
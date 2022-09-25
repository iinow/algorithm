class Solution {
    public String reverseWords(String s) {
        String[] strs = s.replaceAll("^\\s*", "").replaceAll("\\s*$", "").replaceAll("\\s+", " ").split(" ");
        StringBuffer buffer = new StringBuffer();
        for (int i = strs.length - 1; i >= 0; i--) {
            buffer.append(strs[i] + " ");
        }
        return buffer.toString().replaceAll("\\s$", "");
    }
}
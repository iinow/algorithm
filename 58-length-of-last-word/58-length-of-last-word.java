class Solution {
    public int lengthOfLastWord(String s) {
        String[] strs = s.replaceAll("\s$", "").replaceAll("^\s", "").split(" ");
        return strs[strs.length - 1].length();
    }
}
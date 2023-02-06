class Solution {
    public String reverseVowels(String s) {
        int left = 0, right = s.length() - 1;
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('A');
        set.add('e');
        set.add('E');
        set.add('i');
        set.add('I');
        set.add('o');
        set.add('O');
        set.add('u');
        set.add('U');
        while (left < right) {
            if (!set.contains(chars[left])) {
                left++;
                continue;
            }
            if (!set.contains(chars[right])) {
                right--;
                continue;
            }
            
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        
        return new String(chars);
    }
}
class Solution {
    public int maxProduct(String[] words) {
        int MAX = 0;
        
        for (int i = 0; i < words.length - 1; i++) {
            char[] chars = new char[26];
            
            String a = words[i];
            for (char c: a.toCharArray()) {
                chars[c - 'a']++;
            }
            
            for (int j = i + 1; j < words.length; j++) {
                String b = words[j];
                boolean exist = false;
                for (char c: b.toCharArray()) {
                    if (chars[c - 'a'] != 0) {
                        exist = true;
                        break;
                    }
                }
                
                if (exist) {
                    continue;
                }
                
                MAX = Math.max(MAX, a.length() * b.length());
            }
        }
        
        return MAX;
    }
}
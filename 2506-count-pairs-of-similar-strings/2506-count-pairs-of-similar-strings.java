class Solution {
    public int similarPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length - 1; i++) {
            Set<Character> setA = new HashSet<>();
            for (char c: words[i].toCharArray()) {
                setA.add(c);
            }
            
            for (int j = i + 1; j < words.length; j++) {
                Set<Character> setB = new HashSet<>();
                for (char c: words[j].toCharArray()) {
                    setB.add(c);
                }
                
                if (setA.equals(setB)) {
                    count++;
                }
            }
        }
        return count;
    }
}
class Solution {
    public boolean judgeCircle(String moves) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('R', 0);
        map.put('U', 0);
        
        for (char c: moves.toCharArray()) {
            if (c == 'L') {
                map.put('R', map.get('R') - 1);
            } else if (c == 'R' || c == 'U') {
                map.put(c, map.get(c) + 1);
            } else {
                map.put('U', map.get('U') - 1);
            }
        }
        
        return map.get('R') == 0 && map.get('U') == 0;
    }
}
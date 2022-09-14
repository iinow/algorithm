class Solution {
    public int longestPalindrome(String s) {
        var array = s.chars().toArray();
        if (array.length == 1) {
            return 1;
        }

        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 0);
            }
            map.put(array[i], map.get(array[i]) + 1);
        }

        boolean hasRest = false;
        int count = 0;
        Iterator<Integer> iter = map.keySet().iterator();
        while (iter.hasNext()) {
            int key = iter.next();
            int value = map.get(key);
            if (value % 2 == 0) {
                count += value;
            } else {
                if (value / 2 != 0) {
                    count += (value - 1);
                }
                hasRest = true;
            }
        }

        return hasRest ? count + 1 : count;
    }
}
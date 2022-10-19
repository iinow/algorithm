import java.util.*;

class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> map = Map.of("I", 1,
                "V", 5,
                "X", 10,
                "L", 50,
                "C", 100,
                "D", 500,
                "M", 1000);
        var arr = s.toCharArray();

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                sum += map.get(String.valueOf(arr[i]));
                break;
            }
            int value = map.get(String.valueOf(arr[i]));
            int nextValue = map.get(String.valueOf(arr[i + 1]));
            if (value < nextValue) {
                sum += (nextValue - value);
                i++;
                continue;
            } else {
                sum += value;
            }
        }
        return sum;
    }
}
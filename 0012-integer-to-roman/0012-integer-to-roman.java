import java.util.*;

class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> map = Map.of(
                1, "I",
                5, "V",
                10, "X",
                50, "L",
                100, "C",
                500, "D",
                1000, "M");
        Map<String, String> temp = Map.of(
                "V", "I",
                "X", "I",
                "L", "X",
                "C", "X",
                "D", "C",
                "M", "C");
        List<Integer> values = new ArrayList<>();
        map.forEach((k, v) -> {
            values.add(k);
        });
        values.sort((a, b) -> a - b);

        int gisu = 0;
        String s = "";
        while (num != 0) {
            int rest = num % 10;
            int mok = num / 10;
            if (rest == 4 || rest == 9) {
                String v = map.get((rest + 1) * (int) Math.pow(10, gisu));
                s = temp.get(v) + v + s;
            } else {
                // 1, 2, 3, 5, 6, 7, 8, 0
                if (rest != 0) {
                    int v = rest * (int) Math.pow(10, gisu);

                    String left = "";
                    for (int i = values.size() - 1; i >= 0; i--) {
                        int mok2 = v / values.get(i);
                        if (mok2 == 0) {
                            continue;
                        }

                        for (int j = 0; j < mok2; j++) {
                            left = left + map.get(values.get(i));
                        }
                        v = v % values.get(i);
                    }
                    s = left + s;
                }
            }
            num = mok;
            gisu++;
        }
        return s;
    }
}
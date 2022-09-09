import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            String target = strs[i];
            if (target == null) {
                continue;
            }

            List<String> result = new ArrayList<>();
            result.add(target);
            strs[i] = null;

            for (int j = i + 1; j < strs.length; j++) {
                if (j == i) {
                    continue;
                }
                String value = strs[j];
                if (value == null) {
                    continue;
                }

                if (match(target, value)) {
                    result.add(value);
                    strs[j] = null;
                }
            }

            results.add(result);
        }
        return results;
    }

    private boolean match(final String target, String value) {
        if (target.length() != value.length()) {
            return false;
        }

        for (int i = 0; i < target.length(); i++) {
            int find = value.indexOf(target.charAt(i));
            if (find < 0) {
                return false;
            }

            value = value.substring(0, find) + value.substring(find + 1, value.length());
        }
        return true;
    }
}
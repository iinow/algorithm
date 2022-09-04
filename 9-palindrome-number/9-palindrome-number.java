class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        List<Integer> arr = new ArrayList<>();
        while (x > 0) {
            int rest = x % 10;
            x /= 10;
            arr.add(rest);
        }

        if (arr.size() == 1) {
            return true;
        }

        if (arr.size() % 2 != 0) {
            List<Integer> copy = arr;
            int midIndex = arr.size() / 2;
            arr = IntStream.range(0, arr.size()).filter(index -> index != midIndex)
                    .map(index -> {
                        return copy.get(index);
                    })
                    .mapToObj(i -> i)
                    .collect(Collectors.toList());
        }

        for (int i = 0; i < arr.size() / 2; i++) {
            if (arr.get(i) != arr.get(arr.size() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
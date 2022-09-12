class Solution {
    public int maxPoints(int[][] points) {
        Map<String, Set<String>> map = new HashMap<>();
        if (points.length == 1) {
            return 1;
        }

        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int[] a = points[i];
                int[] b = points[j];
                int ax = a[0], ay = a[1];
                int bx = b[0], by = b[1];
                float inc = (bx - ax) == 0 ? 0 : (by - ay) / (float) (bx - ax);
                float r = ay - inc * ax;
                String key = inc + "|" + r;
                if ((bx - ax) == 0) {
                    key = (ax == 0 ? "x" : ax) + "," + 0;
                } else if ((by - ay) == 0) {
                    key = 0 + "," + (ay == 0 ? "y" : ay);
                }

                if (!map.containsKey(key)) {
                    map.put(key, new HashSet<String>());
                }
                map.get(key).add(ax + "|" + ay);
                map.get(key).add(bx + "|" + by);
            }
        }

        return map.values()
                .stream()
                .map(v -> v.size())
                .distinct()
                .mapToInt(v -> v)
                .max()
                .orElse(0);
    }
}
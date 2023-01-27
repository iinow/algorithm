class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> countMap = new TreeMap<>();

        // count, [word]
        Map<Integer, List<String>> map = new TreeMap<>(Collections.reverseOrder());
        for (String word : words) {
            if (!countMap.containsKey(word)) {
                countMap.put(word, 0);
            }
            if (!map.containsKey(countMap.get(word))) {
                map.put(countMap.get(word), new ArrayList<>());
            }

            map.get(countMap.get(word)).remove(word);
            countMap.put(word, countMap.get(word) + 1);
            if (!map.containsKey(countMap.get(word))) {
                map.put(countMap.get(word), new ArrayList<>());
            }
            map.get(countMap.get(word)).add(word);
        }

        Iterator<Integer> iter = map.keySet().iterator();
        while (iter.hasNext()) {
            list.addAll(map.get(iter.next()).stream().sorted().collect(Collectors.toList()));
            if (list.size() > k) {
                break;
            }
        }

        return list.subList(0, k);
    }
}
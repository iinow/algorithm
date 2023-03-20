class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> list1Map = new HashMap<>();
        List<String>[] arr = new List[list1.length + list2.length];
        
        for (int i = 0; i < list1.length; i++) {
            list1Map.put(list1[i], i);
        }
        
        for (int i = 0; i < list2.length; i++) {
            String str = list2[i];
            if (!list1Map.containsKey(str)) {
                continue;
            }
            
            int index = list1Map.get(str) + i;
            if (arr[index] == null) {
                arr[index] = new ArrayList<String>();
            }
            
            arr[index].add(str);
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                continue;
            }
            
            return arr[i].toArray(new String[]{});
        }
        return null;
    }
}
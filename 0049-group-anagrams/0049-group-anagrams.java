import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        
        for(int i=0;i<strs.length;i++){
            String mask = String.valueOf(getMask(strs[i]));
            if(!map.containsKey(mask)){
                map.put(mask,new ArrayList<>());
            }
            map.get(mask).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
    private char[] getMask(String s){
        int n = s.length();
        char[] count = new char[26];
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            count[c-'a']++;
        }
        return count;
    }
}
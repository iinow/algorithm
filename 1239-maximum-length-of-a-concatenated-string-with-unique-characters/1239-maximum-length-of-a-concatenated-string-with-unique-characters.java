import java.util.*;

class Solution {
//     public int maxLength(List<String> arr) {
//         return recursive(arr, 0, "");
//     }
    
//     public int recursive(List<String> arr, int index, String s) {
//         if (Arrays.stream(s.split("")).distinct().count() != s.length()) {
//             return -1;
//         }
        
//         if (arr.isEmpty()) {
//             return s.length();
//         }
        
//         int max = Integer.MIN_VALUE;
//         for (int i = index; i < arr.size(); i++) {
//             max = Math.max(max, recursive(arr, i + 1, s + arr.get(i)));
//         }
//         return max;
//     }
    int max =0;
    public int maxLength(List<String> arr) {
        backTrack(arr,"",0);
        return max;
    }
    
    private void backTrack(List<String> arr, String current, int start){
        if(max < current.length())
            max = current.length();
        for(int i = start; i < arr.size(); i++){
            if (!isValid(current, arr.get(i))) continue;
            backTrack(arr,current + arr.get(i), i + 1);
        }
    }
    
    private boolean isValid(String currentString, String newString){
        return Arrays.stream((currentString + newString).split("")).distinct().count() == (currentString + newString).length();
    }
}
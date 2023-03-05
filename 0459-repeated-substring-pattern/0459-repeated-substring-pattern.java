class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String str=s+s;
		String str1=str.substring(1, str.length()-1); 
		if(str1.contains(s)) 				
			return true;
		else
		   return false;
    }
}
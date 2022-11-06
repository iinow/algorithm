class Solution {
    public String orderlyQueue(String s, int k) {
        int n=s.length();
        if(k==1) {
            String doublestring=s+s;
            String ans=s;
            for(int i=0;i<n;i++) {
                String substr=doublestring.substring(i,n + i);
                if(substr.compareTo(ans) < 0) {
                    ans=substr;
                }
            }
            return ans;
        }
        //if k>1
        char[] ar = s.toCharArray();
        Arrays.sort(ar);
        String sorted = String.valueOf(ar);
        return sorted;
    }
}
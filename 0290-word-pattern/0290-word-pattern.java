class Solution {
    public boolean wordPattern(String pattern, String str) 
    {
        HashMap<Character,String>h=new HashMap<>();
        String [] s=str.split("\\ ");
        char c='a';
        String b="";
        if(s.length!=pattern.length())return false;
        for(int i=0;i<s.length;i++)
        {
            c=pattern.charAt(i);
            b=s[i];
            if(!h.containsKey(c) && !h.containsValue(b))
            {
                h.put(c,b);
            }
            else if(h.containsKey(c))
            {
                if(!h.get(c).equals(b))
                {
                    return false;
                }
            }
            else if(h.containsValue(b))
            {
                int x=0;
                for(Map.Entry<Character,String> m:h.entrySet())
                {
                    if(m.getValue()==b)
                    {
                        x=m.getKey();
                    }
                }
                if(x!=c)return false;
            }
        }
        return true;
    }
}
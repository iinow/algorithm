import java.util.regex.*;

class Solution {
    public boolean isNumber(String s) {
        Pattern p = Pattern.compile("[+-]?((\\d+)|((\\d+\\.)|(\\d+\\.\\d+)|(\\.\\d+)))(e[+-]?\\d+)?");
        Matcher m=p.matcher(s.toLowerCase());
        return m.matches();
    }
}
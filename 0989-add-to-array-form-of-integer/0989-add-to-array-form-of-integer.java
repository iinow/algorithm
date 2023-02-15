import java.math.BigDecimal;
import java.math.BigInteger;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        return String.valueOf((new BigInteger(Arrays.stream(num).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString())).add(new BigInteger(String.valueOf(k)))).chars().mapToObj(c -> c - '0').collect(Collectors.toList());
    }
}
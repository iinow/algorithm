package algorithm.codeup.recursion;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex3702 {

    private static final Map<String, BigDecimal> temp = new HashMap<>();

    public static void main(String[] args) {
        new Ex3702().solution();
    }

    public void solution() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int r = scanner.nextInt();

        System.out.println(recursive(BigDecimal.valueOf(n), BigDecimal.valueOf(r)).remainder(BigDecimal.valueOf(100_000_000L)));
    }

    public BigDecimal recursive(BigDecimal n, BigDecimal r) {
        if(temp.containsKey(createKey(n, r))) {
            return temp.get(createKey(n, r));
        }

        if(n.equals(BigDecimal.valueOf(1)) || r.equals(BigDecimal.valueOf(1))) {
            return BigDecimal.valueOf(1);
        }

        BigDecimal x = recursive(n, r.subtract(BigDecimal.valueOf(1)));
        temp.put(createKey(n, r.subtract(BigDecimal.valueOf(1))), x);

        BigDecimal y = recursive(n.subtract(BigDecimal.valueOf(1)), r);
        temp.put(createKey(n.subtract(BigDecimal.valueOf(1)), r), y);

        return x.add(y);
    }

    private String createKey(BigDecimal n, BigDecimal r) {
        return String.format("%s|%s", n.toString(), r.toString());
    }
}

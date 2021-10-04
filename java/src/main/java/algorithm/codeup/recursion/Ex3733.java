package algorithm.codeup.recursion;

import java.math.BigDecimal;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex3733 {

    private Map<BigDecimal, BigDecimal> temp = new HashMap<>();

    public static void main(String[] args) {
        new Ex3733().solution();
    }

    public void solution() {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(" ");

        int start = Integer.parseInt(inputs[0]);
        int end = Integer.parseInt(inputs[1]);

        Map.Entry<Integer, Integer> entry = new AbstractMap.SimpleEntry<>(0, 0);
        for(int i = start; i <= end; i++) {
            int length = recursive(BigDecimal.valueOf(i));
            if(length > entry.getValue()) {
                entry = new AbstractMap.SimpleEntry<>(i, length);
            }
        }

        System.out.printf("%d %d%n", entry.getKey(), entry.getValue());
    }

    public int recursive(BigDecimal value) {
        if(value.equals(BigDecimal.valueOf(1))) {
            return 1;
        }

        BigDecimal result;
        if(temp.get(value) !=  null) {
            result = temp.get(value);
        } else {
            result = isOdd(value) ? calculateOdd(value) : calculateEven(value);
            temp.put(value, result);
        }

        return recursive(result) + 1;
    }

    public boolean isOdd(BigDecimal value) {
        return value.remainder(BigDecimal.valueOf(2)).equals(BigDecimal.valueOf(1));
    }

    public BigDecimal calculateOdd(BigDecimal value) {
        return value.multiply(BigDecimal.valueOf(3)).add(BigDecimal.valueOf(1));
    }

    public BigDecimal calculateEven(BigDecimal value) {
        return value.divide(BigDecimal.valueOf(2));
    }
}

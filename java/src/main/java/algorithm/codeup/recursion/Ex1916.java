package algorithm.codeup.recursion;

import java.math.BigDecimal;
import java.util.Scanner;

public class Ex1916 {

    public static void main(String[] args) {
        new Ex1916().solution();
    }

    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int startIndex = 2;

        BigDecimal result = recursive(input, startIndex, BigDecimal.valueOf(0), BigDecimal.valueOf(1), BigDecimal.valueOf(1)).remainder(BigDecimal.valueOf(10009));

        System.out.println(result);
    }

    public BigDecimal recursive(int input, int startIndex, BigDecimal value, BigDecimal first, BigDecimal second) {
        if(input <= 2) {
            return BigDecimal.valueOf(1);
        }

        if(input == startIndex) {
            return value;
        }

        BigDecimal sum = first.add(second);

        return recursive(input, startIndex + 1, sum, second, sum);
    }
}

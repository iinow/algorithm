package algorithm.codeup.recursion;

import java.util.*;

public class Ex3733 {

    private Map<Long, Long> temp = new HashMap<>();

    public static void main(String[] args) {
        new Ex3733().solution();
    }

    public void solution() {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(" ");

        long start = Long.parseLong(inputs[0]);
        long end = Long.parseLong(inputs[1]);

        long[] entry = {0, 0};
        for(long i = start; i <= end; i++) {
            long length = recursive(i);
            if(length > entry[1]) {
                entry = new long[]{i, length};
            }
        }

        System.out.printf("%d %d%n", entry[0], entry[1]);
    }

    public long recursive(long value) {
        if(value == 1) {
            return 1;
        }

        if(temp.containsKey(value)) {
            return temp.get(value);
        }

        if(isOdd(value)) {
            temp.put(value, recursive(calculateOdd(value)) + 1);
        } else {
            temp.put(value, recursive(calculateEven(value)) + 1);
        }

        return temp.get(value);
    }

    public boolean isOdd(long value) {
        return value % 2 == 1;
    }

    public long calculateOdd(long value) {
        return (3L * value) + 1;
    }

    public long calculateEven(long value) {
        return value / 2;
    }
}

package algorithm.codeup.recursion;

import java.util.*;

public class Ex1930 {

    private static final Map<String, Integer> temp = new HashMap<>();

    public static void main(String[] args) {
        new Ex1930().solution();
    }

    public void solution() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> result = new ArrayList<>();
        while(scanner.hasNext()) {
            String[] inputs = scanner.nextLine().split(" ");
            if(inputs[0].equals("EOF")) {
                break;
            }

            int k = Integer.parseInt(inputs[0]);
            int n = Integer.parseInt(inputs[1]);

            result.add(recursive(k, n));
        }

        result.forEach(v -> System.out.printf("%d\n", v));
    }

    public int recursive(int k, int n) {
        if(k == 0) {
            return n;
        }

        if(temp.containsKey(String.format("%d|%d", k, n))) {
            return temp.get(String.format("%d|%d", k, n));
        }

        int sum = 0;
        int index = 1;
        while(true) {
            int res = recursive(k - 1, index);
            temp.put(String.format("%d|%d", k - 1, index), res);

            sum += res;
            index += 1;

            if(index > n) {
                break;
            }
        }

        temp.put(String.format("%d|%d", k, n), sum);

        return temp.get(String.format("%d|%d", k, n));
    }
}

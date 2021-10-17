package algorithm.codeup.binarysearch;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Stream;

public class Ex2629 {
    public static void main(String[] args) {
        new Ex2629().solution();
    }

    public void solution() {
        Scanner scanner = new Scanner(System.in);
        String[] first = scanner.nextLine().split(" ");
        int cntCity = Integer.parseInt(first[0]);
        int cntCitizen = Integer.parseInt(first[1]);

        Map<Double, Integer> temp = new TreeMap<>();

        for (int i = 0; i < cntCity; i++) {
            int[] arr = Stream.of(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int x = arr[0];
            int y = arr[1];
            int citizen = arr[2];

            double key = Math.sqrt(Math.pow(Math.abs(x), 2) + Math.pow(Math.abs(y), 2));
            temp.put(key, citizen + temp.getOrDefault(key, 0));
        }

        Iterator<Double> iter = temp.keySet().iterator();
        while(iter.hasNext()) {
            double key = iter.next();
            cntCitizen += temp.get(key);
            if(cntCitizen >= 1_000_000) {
                System.out.printf("%.3f%n", key);
                return;
            }
        }
        System.out.println(-1);
    }
}

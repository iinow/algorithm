package algorithm.baekjoon;

import java.util.HashSet;
import java.util.Scanner;

public class BQ9663 {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        var temp = new HashSet<Integer>();
        var columnTemp = new HashSet<Integer>();

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j  <= n; j++) {
                var v = Math.abs(j-i);
                if(temp.contains(v)) {
                    continue;
                }

                if(columnTemp.contains(j)) {
                    continue;
                }
                temp.add(v);
                columnTemp.add(j);
                break;
            }
        }

        if(columnTemp.size() == n) {
            System.out.println(columnTemp);
        }
    }

    public int recursive(int columnIndex) {

    }
}

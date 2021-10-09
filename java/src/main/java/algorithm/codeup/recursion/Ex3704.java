package algorithm.codeup.recursion;

import java.util.Scanner;

public class Ex3704 {

    public static void main(String[] args) {
        new Ex3704().solution();
    }

    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] temp = new int[100001];
        temp[0] = 0;
        temp[1] = 1;
        temp[2] = 2;
        temp[3] = 4;

        System.out.println(recursive(n, temp));
    }

    public int recursive(int n, int[] temp) {
        if(n < 4) {
            return temp[n];
        }

        int index = 4;
        while(true) {
            temp[index] = (temp[index - 1] + temp[index - 2] + temp[index - 3]) % 1000;
            if(index == n) {
                return temp[n];
            }
            index ++;
        }
    }
}

package algorithm.kstech;

import java.util.Scanner;

public class P2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        for(int r = 0; r < b; r++) {
        	for(int h = 0; h < a; h++) {
        		 System.out.print("*");
        	}
        	System.out.println();
        }
	}
}

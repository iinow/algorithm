package algorithm.codeup.dp;

import java.math.BigInteger;
import java.util.Scanner;

public class Ex2640 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		
		BigInteger ii = powerWithImp(new BigInteger(String.valueOf(n)), k);
		
		ii = ii.mod(mod);
		System.out.println(ii.toString());
	}
	
	static final BigInteger mod = new BigInteger("1000000007");
	
	public static BigInteger powerWithImp(BigInteger n, int k) {
	    if(k == 0) return new BigInteger("1");
	    if(k == 1) return n;
	    if(k % 2 == 0)
	        return powerWithImp(n.multiply(n).mod(mod), k/2);
	    else
	        return n.multiply(powerWithImp(n.multiply(n).mod(mod), k/2));
	}
}

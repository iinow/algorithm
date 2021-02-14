package algorithm.brother;

import java.util.Arrays;

public class Ex4 {
	int solution(int[] A, int[] B) {
		int n = A.length;
        int m = B.length;;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;
        for (int k = 0; k < (n > m ? n : m); k++) {
            if (i < (n > m ? m : n) - 1 && B[i] < A[k])
                i += 1;
            if (A[k] == B[i])
                return A[k];
        }
        return -1;
    }
	
	public static void main(String[] args) {
		int[] A = {1, 3, 2, 1};
		int[] B = {4, 2, 5, 3, 2};
		System.out.println(new Ex4().solution(A, B));
	}
}

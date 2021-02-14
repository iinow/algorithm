package algorithm.brother;

public class Ex1 {
	public String solution(int U, int L, int[] C) {
        // write your code in Java SE 8
        int[][] array = new int[2][C.length];
        
        for(int i = 0; i < C.length; i++) {
        	if(C[i] == 2) {
        		array[1][i] = 1;
        		array[2][i] = 1;
        	}else {
        		array[1][i] = 2;
        		array[2][i] = 2;
        	}
        }
        
        return "";
    }
}

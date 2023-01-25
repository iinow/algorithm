class Solution {
    public String getHint(String secret, String guess) {
        char[] chars = secret.toCharArray();
        int bulls = 0, cows = 0;
        int[] tempA = new int[10];
        int[] tempB = new int[10];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == guess.charAt(i)) {
                bulls++;
            } else {
                tempA[guess.charAt(i) - 48]++;
                tempB[(int)chars[i] - 48]++;
            }
        }
        
        for (int i = 0; i < tempA.length; i++) {
            if (tempA[i] == 0 || tempB[i] == 0) continue;
            cows += Math.min(tempA[i], tempB[i]);
        }
        
        return bulls + "A" + cows + "B";
    }
}
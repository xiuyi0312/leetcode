package com.op.leetcode;

public class AlphabeticalOrder {

    public static void main(String[] args) {
        AlphabeticalOrder alphabeticalOrder = new AlphabeticalOrder();
        System.out.println(alphabeticalOrder.countVowelStrings(5));
    }

    public int countVowelStrings(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 5;
        }
        int[][] f = new int[n][5];
        for (int i = 0; i < 5; i++) {
            f[0][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            f[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 5; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += f[n - 1][i];
        }
        return sum;
//        a 	e 	i 	o 	u
//        1 	1 	1 	1 	1
//        1 	2 	3 	4 	5
//        1 	3 	6 	10 	15
//        1	4	10	20	35
//        1	5	15	35	70
//        1	6	21	56	126
    }
}

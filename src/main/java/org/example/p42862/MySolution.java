package org.example.p42862;

import java.util.Arrays;

/**
 * 5   [2, 4]	[1, 3, 5]	=>  5
 * 5   [2, 4]	[3]	        =>  4
 * 3   [3]	    [1]         => 	2
 */
public class MySolution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] check = new int[n];

        for (int i : lost) {
            check[i - 1]--;
        }
        for (int i : reserve) {
            check[i - 1]++;
        }

        int max = -1;

        for (int i = 0; i < check.length; i++) {
            if (check[i] == 1) {
                if (i > 0 && check[i - 1] == -1) {
                    check[i]--;
                    check[i - 1]++;
                } else if (i < check.length - 1 && check[i + 1] == -1) {
                    check[i]--;
                    check[i + 1]++;
                }
            }
        }

        return (int) Arrays.stream(check)
                .filter(e -> e >= 0)
                .count();
    }
}
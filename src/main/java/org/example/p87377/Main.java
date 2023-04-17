package org.example.p87377;

public class Main {
}

class Solution {
    public String[] solution(int[][] line) {
        String[] answer = {};
        return answer;
    }

    public long[] intersection(int[] line1, int[] line2) {
        long A = line1[0];
        long B = line1[1];
        long E = line1[2];

        long C = line2[0];
        long D = line2[1];
        long F = line2[2];

        // 분모가 0일 경우, 평행이여서 교점이 없다.
        if(A * D - B * C == 0) {
            return null;
        }

        double x = (double) (B * F - E * D) / (A * D - B * C);
        double y = (double) (E * C - A * F) / (A * D - B * C);

        // 정수인지 아닌지 판별
        if(x != (long) x) return null;
        if(y != (long) y) return null;

        return new long[]{(long) x, (long) y};
    }
}
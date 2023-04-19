package org.example.p12946;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] solution(int n) {
        return new Hanoi(1, 3, n).toArray();
    }
}

class Hanoi {
    private final List<int[]> paths = new ArrayList<>();

    public Hanoi(int from, int to, int n) {
        calculate(from, to, n, 1);
    }

    // from : 시작점
    // to : 목적지
    // n : 옮길 원판 개수
    // empty : from 도 아니고 to 도 아닌 기둥 번호
    private void calculate(int from, int to, int n, int depth) {
        String debugLineHead = "\t".repeat(depth - 1) + "(%d) => (%d), %d개 옮기기".formatted(from, to, n);

        System.out.println(debugLineHead + " - 시작");

        if (n == 1) {
            addPath(from, to);

            System.out.println(debugLineHead + " - 끝");
            return;
        }

        int empty = 6 - from - to;

        calculate(from, empty, n - 1, depth + 1);
        calculate(from, to, 1, depth + 1);
        calculate(empty, to, n - 1, depth + 1);

        System.out.println(debugLineHead + " - 끝");
    }

    private void addPath(int from, int to) {
        paths.add(new int[]{from, to});
    }

    public int[][] toArray() {
        // List<int[]> => int[][]
        return paths
                .stream()
                .toArray(int[][]::new);
    }
}
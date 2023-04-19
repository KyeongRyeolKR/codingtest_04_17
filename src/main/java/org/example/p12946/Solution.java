package org.example.p12946;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] solution(int n) {
        return new Hanoi(1, 3, n).toArray();
    }
}

class Hanoi {
    private final int FROM;
    private final int TO;
    private final int N;
    private final List<int[]> paths = new ArrayList<>();

    public Hanoi(int from, int to, int n) {
        this.FROM = from;
        this.TO = to;
        this.N = n;

        calculate();
    }

    private void calculate() {
        if (N == 1) addPath(1, 3);
        if (N == 2 && FROM == 1 && TO == 2) {
            addPath(1, 3);
            addPath(1, 2);
            addPath(3, 2);
        }
        if (N == 2 && FROM == 1 && TO == 3) {
            addPath(1, 2);
            addPath(1, 3);
            addPath(2, 3);
        }
        if (N == 2 && FROM == 2 && TO == 1) {
            addPath(2, 3);
            addPath(2, 1);
            addPath(3, 1);
        }
        if (N == 2 && FROM == 2 && TO == 3) {
        }
        if (N == 2 && FROM == 3 && TO == 1) {
        }
        if (N == 2 && FROM == 3 && TO == 2) {
        }
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
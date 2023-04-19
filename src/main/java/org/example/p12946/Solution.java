package org.example.p12946;

class Solution {
    public int[][] solution(int n) {
        return new Hanoi(1, 3, n).toArray();
    }
}

class Hanoi {
    private final int FROM;
    private final int TO;
    private final int N;

    public Hanoi(int from, int to, int n) {
        this.FROM = from;
        this.TO = to;
        this.N = n;
    }

    public int[][] toArray() {
        if (N == 1) return new int[][]{{1, 3}};
        if (N == 2 && FROM == 1 && TO == 2) return new int[][]{{1, 3}, {1, 2}, {3, 2}};
        if (N == 2 && FROM == 1 && TO == 3) return new int[][]{{1, 2}, {1, 3}, {2, 3}};
        if (N == 2 && FROM == 2 && TO == 1) return new int[][]{{2, 3}, {2, 1}, {3, 1}};
        if (N == 2 && FROM == 2 && TO == 3) return null;
        if (N == 2 && FROM == 3 && TO == 1) return null;
        if (N == 2 && FROM == 3 && TO == 2) return null;

        return null;
    }
}
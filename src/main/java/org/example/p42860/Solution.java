package org.example.p42860;

class Solution {
    public static boolean isDebug = false;

    public int solution(String name) {
        return nameCost(name) + moveCost(name);
    }

    private int nameCost(String name) {
        int nameCost = 0;

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);

            int diff1 = c - 'A';
            int diff2 = 'Z' - c + 1;
            int diff = Math.min(diff1, diff2);

            nameCost += diff;
        }

        return nameCost;
    }

    private int moveCost(String name) {
        int moveCost = 0;

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);

            int diff = c - 'A';

            if (diff > 0) {
                moveCost = i;
            }
        }

        return moveCost;
    }
}
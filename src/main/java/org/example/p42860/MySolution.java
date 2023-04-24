package org.example.p42860;

import java.util.Arrays;

/**
 * "JEROEN"	=>  56
 * "JAN"	=>  23
 */
class MySolution {
    public int solution(String name) {
        int upDownCount = 0;
        int leftRightCount = name.length()-1;

        int endA = 0;
        for(int i=0; i<name.length(); i++) {
            int case1 = Math.abs(name.charAt(i) - 'A');
            int case2 = Math.abs(name.charAt(i) - 91);
            upDownCount += Math.min(case1, case2);

            endA = i+1;
            while(endA < name.length() && name.charAt(endA) == 'A') {
                endA++;
            }

            leftRightCount = Math.min(leftRightCount, i * 2 + name.length() - endA);
            leftRightCount = Math.min(leftRightCount, (name.length() - endA) * 2 + i);
        }

        return upDownCount + leftRightCount;
    }

    public static void main(String[] args) {
        System.out.println(new MySolution().solution("JAN"));
    }
}
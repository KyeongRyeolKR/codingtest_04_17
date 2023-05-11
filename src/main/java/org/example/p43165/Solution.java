package org.example.p43165;

class Solution {
    public int solution(int[] numbers, int target) {
        return new NumberOfCases(numbers, target).calc();
    }
}

class NumberOfCases {
    private final int[] numbers;
    private final int target;

    public NumberOfCases(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
    }

    int calc() {
        return calc(0, 0, "0");
    }

    private int calc(int depth, int sum, String history) {
        // 내가 끝방에 있을 때
        if (depth == numbers.length) {
            System.out.println("history : " + history + " = " + sum);
            return sum == target ? 1 : 0;
        }

        // 그렇지 않을 때는 탐색을 이어 간다.
        // 각 방마다 통로가 위쪽(+), 아래쪽(-)이 있다.
        return calc(depth + 1, sum + numbers[depth], history + " + " + numbers[depth])
                + calc(depth + 1, sum - numbers[depth], history + " - " + numbers[depth]);
    }
}
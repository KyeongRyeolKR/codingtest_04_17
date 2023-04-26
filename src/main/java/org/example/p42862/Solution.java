package org.example.p42862;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public static boolean isDebug;

    public int solution(int n, int[] lostArr, int[] reserveArr) {
        // 리스트 화
        List<Integer> lost = Arrays.stream(lostArr).boxed().sorted().collect(Collectors.toCollection(ArrayList::new)); // 가변 리스트
        List<Integer> reserve = Arrays.stream(reserveArr).boxed().sorted().collect(Collectors.toCollection(ArrayList::new)); // 가변 리스트

        borrowSelf(lost, reserve);

        // 참석하지 못하는 학생들의 수, 초기값을 지정
        int notAttendCount = lost.size();

        // 체육복 빌리기를 시전한다.
        // 빌리는데 성공한 사람의 수 만큼 notAttendCount 에서 빼준다.
        notAttendCount -= borrow(lost, reserve);

        return n - notAttendCount;
    }

    private void borrowSelf(List<Integer> lost, List<Integer> reserve) {
        /* 절대 하면 안되는 코드 */
        /*
        for ( int n : lost ) {
            if ( reserve.contains(n) ) {
                lost.remove(Integer.valueOf(n));
                reserve.remove(Integer.valueOf(n));
            }
        }
        */

        List<Integer> self = lost
                .stream()
                .filter(n -> reserve.contains(n))
                .collect(Collectors.toList());

        self.forEach(n -> {
            lost.remove(Integer.valueOf(n));
            reserve.remove(Integer.valueOf(n));
        });
    }

    public int borrow(List<Integer> lost, List<Integer> reserve) {
        int borrowCount = 0;

        for (int no : lost) {
            if (borrow(no, reserve)) {
                borrowCount++;
            }
        }

        return borrowCount;
    }

    private boolean borrow(int n, List<Integer> reserve) {
        if (reserve.contains(n - 1)) {
            reserve.remove(Integer.valueOf(n - 1));
            return true;
        }

        if (reserve.contains(n + 1)) {
            reserve.remove(Integer.valueOf(n + 1));
            return true;
        }

        return false;
    }
}
package org.example.p12946;

import java.util.ArrayList;
import java.util.List;

public class MySolution {
    static List<int[]> paths = new ArrayList<>();

    public int[][] solution(int n) {
        // 출발 기둥 : 1번
        // 목적 기둥 : 3번
        // 원판 개수 : n개
        dfs(1,3,n);
        return paths.toArray(int[][]::new);
    }

    /**
     * 원판을 옮기는 메소드
     * @param from : from 기둥에서
     * @param to : to 기둥으로
     * @param n : n 개 옮긴다.
     */
    private static void dfs(int from, int to, int n) {
        // 옮기는 원판의 개수가 1개일 때만 움직일 수 있으므로, n = 1 일때만 paths 에 옮기는 기둥 정보를 등록시킨다.
        if(n == 1) {
            paths.add(new int[]{from, to});
            return;
        }

        // 비어있는 기둥 => 1,2,3번 기둥이 존재하기에 6에서 시작과 끝 기둥번호를 빼주면 빈 기둥번호를 찾을 수 있음
        int empty = 6 - from - to;

        // 1단계 : from 에서 empty 기둥으로 (n-1)개를 옮긴다.
        dfs(from, empty, n - 1);
        // 2단계 : from 에서 to 기둥으로 나머지(1개)를 옮긴다.
        dfs(from, to, 1);
        // 3단계 : empty 기둥에 옮겨뒀던 (n-1)개의 원판을 to 기둥으로 옮긴다.
        dfs(empty, to, n - 1);
    }
}


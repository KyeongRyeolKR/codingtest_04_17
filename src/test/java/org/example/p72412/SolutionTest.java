package org.example.p72412;

import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.MethodName.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SolutionTest {
    private final String[] info = new String[]{
            "java backend junior pizza 150",
            "python frontend senior chicken 210",
            "python frontend senior chicken 150",
            "cpp backend senior pizza 260",
            "java backend junior chicken 80",
            "python backend senior chicken 50"
    };

    private final String[] query = new String[]{
            "java and backend and junior and pizza 100",
            "python and frontend and senior and chicken 200",
            "cpp and - and senior and pizza 250",
            "- and backend and senior and - 150",
            "- and - and - and chicken 100",
            "- and - and - and - 150"
    };

    @Test
    @DisplayName("python frontend senior chicken → 150, 210")
    void t1() {
        Map<String, List<Integer>> scoresMap = new Solution().buildScoresMap(info);

        List<Integer> scores = scoresMap.get("python frontend senior chicken");

        assertThat(scores).containsExactly(150, 210);
    }

    @Test
    @DisplayName("java - - - → 80, 150")
    void t2() {
        Map<String, List<Integer>> scoresMap = new Solution().buildScoresMap(info);

        List<Integer> scores = scoresMap.get("java - - -");

        assertThat(scores).containsExactly(80, 150);
    }

    @Test
    @DisplayName("python - - - → 50, 150, 210")
    void t3() {
        Map<String, List<Integer>> scoresMap = new Solution().buildScoresMap(info);

        List<Integer> scores = scoresMap.get("python - - -");

        assertThat(scores).containsExactly(50, 150, 210);
    }

    @Test
    @DisplayName("- - senior - → 50, 150, 210, 260")
    void t4() {
        Map<String, List<Integer>> scoresMap = new Solution().buildScoresMap(info);

        List<Integer> scores = scoresMap.get("- - senior -");

        assertThat(scores).containsExactly(50, 150, 210, 260);
    }

    @Test
    @DisplayName("print all queries")
    void t5() {
        new Solution().getAllQueries().forEach(System.out::println);
    }

    @Test
    @DisplayName("[2, 4, 6, 8, 10, 12, 14], 8 → 4")
    void t6() {
        assertThat(
                new Solution().countBiggerThan(List.of(2, 4, 6, 8, 10, 12, 14), 8)
        ).isEqualTo(4);
    }

    @Test
    @DisplayName("solution")
    void t7() {
        assertThat(
                new Solution().solution(info, query)
        ).containsExactly(1, 1, 1, 1, 2, 4);
    }
}
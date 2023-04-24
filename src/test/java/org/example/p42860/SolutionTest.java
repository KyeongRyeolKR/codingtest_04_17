package org.example.p42860;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.MethodName.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SolutionTest {
    @BeforeAll
    void beforeAll() {
        Solution.isDebug = true;
    }

    @Test
    @DisplayName("BAA → 1")
    void t01() {
        assertThat(
                new Solution().solution("BAA")
        ).isEqualTo(
                1
        );
    }

    @Test
    @DisplayName("CAA → 2")
    void t02() {
        assertThat(
                new Solution().solution("CAA")
        ).isEqualTo(
                2
        );
    }

    @Test
    @DisplayName("BBA → 3")
    void t03() {
        assertThat(
                new Solution().solution("BBA")
        ).isEqualTo(
                3
        );
    }

    @Test
    @DisplayName("ZBA → 3")
    void t04() {
        assertThat(
                new Solution().solution("ZBA")
        ).isEqualTo(
                3
        );
    }

    @Test
    @DisplayName("O → 12")
    void t05() {
        assertThat(
                new Solution().solution("O")
        ).isEqualTo(
                12
        );
    }

    @Test
    @DisplayName("N → 13")
    void t06() {
        assertThat(
                new Solution().solution("N")
        ).isEqualTo(
                13
        );
    }

    @Test
    @DisplayName("KAABC, moveCostBy1 → 4")
    void t07() {
        assertThat(
                new Solution().moveCostBy1("KAABC")
        ).isEqualTo(
                4
        );
    }

    @Test
    @DisplayName("KAABCAAA, moveCostBy1 → 4")
    void t08() {
        assertThat(
                new Solution().moveCostBy1("KAABCAAA")
        ).isEqualTo(
                4
        );
    }

    @Test
    @DisplayName("KAABC, moveCostBy2 → 2")
    void t09() {
        assertThat(
                new Solution().moveCostBy2("KAABC")
        ).isEqualTo(
                2
        );
    }

    @Test
    @DisplayName("KZABC, moveCostBy2 → 4")
    void t10() {
        assertThat(
                new Solution().moveCostBy2("KZABC")
        ).isEqualTo(
                4
        );
    }

    @Test
    @DisplayName("AAAAA, moveCostBy2 → 0")
    void t11() {
        assertThat(
                new Solution().moveCostBy2("AAAAA")
        ).isEqualTo(
                0
        );
    }

    @Test
    @DisplayName("Ut.getLongestCharContinuumIndexAndLength(\"KBAAAATK\", 'A') → rs.index: 2, rs.length: 4")
    void t12() {
        assertThat(
                Ut.getLongestCharContinuumIndexAndLength("KBAAAATK", 'A')
        ).isEqualTo(
                new Ut.LongestCharContinuumIndexAndLength(2, 4)
        );
    }

    @Test
    @DisplayName("Ut.getLongestCharContinuumIndexAndLength(\"KAAAABAAAATK\", 'A') → rs.index: 1, rs.length: 4")
    void t13() {
        assertThat(
                Ut.getLongestCharContinuumIndexAndLength("KAAAABAAAATK", 'A')
        ).isEqualTo(
                new Ut.LongestCharContinuumIndexAndLength(1, 4)
        );
    }

    @Test
    @DisplayName("ABCDAAAAKK, moveCostBy3 → 7")
    void t14() {
        assertThat(
                new Solution().moveCostBy3("ABCDAAAAKK")
        ).isEqualTo(
                7
        );
    }

    @Test
    @DisplayName("ADAAAABCDKK, moveCostBy3 → 11")
    void t15() {
        assertThat(
                new Solution().moveCostBy3("ADAAAABCDKK")
        ).isEqualTo(
                11
        );
    }

    @Test
    @DisplayName("ADAAAABCDKK, moveCostBy4 → 7")
    void t16() {
        assertThat(
                new Solution().moveCostBy4("ADAAAABCDKK")
        ).isEqualTo(
                7
        );
    }

    @Test
    @DisplayName("KKAAE, moveCostBy4 → 3")
    void t17() {
        assertThat(
                new Solution().moveCostBy4("KKAAE")
        ).isEqualTo(
                3
        );
    }

    @Test
    @DisplayName("ADAAAABCDKK, moveCost → 7")
    void t18() {
        assertThat(
                new Solution().moveCost("ADAAAABCDKK")
        ).isEqualTo(
                7
        );
    }

    @Test
    @DisplayName("JEROEN, solution → 56")
    void t19() {
        assertThat(
                new Solution().solution("JEROEN")
        ).isEqualTo(
                56
        );
    }

    @Test
    @DisplayName("JAN, solution → 23")
    void t20() {
        assertThat(
                new Solution().solution("JAN")
        ).isEqualTo(
                23
        );
    }
}
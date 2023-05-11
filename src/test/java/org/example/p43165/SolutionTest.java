package org.example.p43165;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.MethodName.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SolutionTest {
    @Test
    @DisplayName("{1, 1, 1, 1, 1}, 3 → 5")
    void t01() {
        assertThat(
                new Solution().solution(new int[]{1, 1, 1, 1, 1}, 3)
        ).isEqualTo(
                5
        );
    }

    @Test
    @DisplayName("{4, 1, 2, 1}, 4 → 2")
    void t02() {
        assertThat(
                new Solution().solution(new int[]{4, 1, 2, 1}, 4)
        ).isEqualTo(
                2
        );
    }
}
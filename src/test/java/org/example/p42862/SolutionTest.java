package org.example.p42862;

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
    @DisplayName("3, [3], [1], → 2")
    void t1() {
        assertThat(
                new Solution().solution(3, new int[]{3}, new int[]{1})
        ).isEqualTo(2);
    }

    @Test
    @DisplayName("5, [2, 4], [3] → 4")
    void t2() {
        assertThat(
                new Solution().solution(5, new int[]{2, 4}, new int[]{3})
        ).isEqualTo(4);
    }

    @Test
    @DisplayName("3, [3], [1] → 2")
    void t3() {
        assertThat(
                new Solution().solution(3, new int[]{3}, new int[]{1})
        ).isEqualTo(2);
    }
}
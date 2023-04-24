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
}
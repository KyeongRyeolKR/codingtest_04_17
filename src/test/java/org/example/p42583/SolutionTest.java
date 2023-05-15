package org.example.p42583;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void t1() {
        assertThat(
                new Solution().solution(100, 100, new int[]{10})
        ).isEqualTo(
                101
        );
    }
}
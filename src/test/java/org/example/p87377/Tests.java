package org.example.p87377;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Tests {

    @Test
    @DisplayName("교점 : [[1, -1, 0], [2, -1, 0]]")
    void t1() {
        assertThat(new Solution().intersection(new int[]{1, -1, 0}, new int[]{2, -1, 0}))
                .isEqualTo(new long[]{0, 0});
    }

    @Test
    @DisplayName("교점 : [[1, -1, 0], [4, -1, 0]]")
    void t1_2() {
        assertThat(new Solution().intersection(new int[]{1, -1, 0}, new int[]{4, -1, 0}))
                .isEqualTo(new long[]{0, 0});
    }

    @Test
    @DisplayName("교점 : [[2, -1, 0], [4, -1, 0]]")
    void t1_3() {
        assertThat(new Solution().intersection(new int[]{2, -1, 0}, new int[]{4, -1, 0}))
                .isEqualTo(new long[]{0, 0});
    }
}
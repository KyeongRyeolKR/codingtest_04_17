package org.example.p87377;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Tests {

    @Test
    @DisplayName("교점 : [[1, -1, 0], [2, -1, 0]]")
    void t1() {
        assertThat(new Solution().intersection(new int[]{1, -1, 0}, new int[]{2, -1, 0}))
                .isEqualTo(Point.of(0, 0));
    }

    @Test
    @DisplayName("교점 : [[1, -1, 0], [4, -1, 0]]")
    void t1_2() {
        assertThat(new Solution().intersection(new int[]{1, -1, 0}, new int[]{4, -1, 0}))
                .isEqualTo(Point.of(0, 0));
    }

    @Test
    @DisplayName("교점 : [[2, -1, 0], [4, -1, 0]]")
    void t1_3() {
        assertThat(new Solution().intersection(new int[]{2, -1, 0}, new int[]{4, -1, 0}))
                .isEqualTo(Point.of(0, 0));
    }

    @Test
    @DisplayName("교점 : [[0, 1, -1], [1, 0, -1]]")
    void t1_4() {
        assertThat(new Solution().intersection(new int[]{0, 1, -1}, new int[]{1, 0, -1}))
                .isEqualTo(Point.of(1, 1));
    }

    @Test
    @DisplayName("교점 : [[0, 1, -1], [1, 0, 1]]")
    void t1_5() {
        assertThat(new Solution().intersection(new int[]{0, 1, -1}, new int[]{1, 0, 1}))
                .isEqualTo(Point.of(-1, 1));
    }

    @Test
    @DisplayName("교점들 : [[1, -1, 0], [2, -1, 0]]")
    void t2() {
        assertThat(new Solution().intersections(new int[][]{{0, 1, -1},{1, 0, 1}}))
                .isEqualTo(Set.of(Point.of(-1, 1)));
    }

    @Test
    @DisplayName("교점들 : [[0, 1, -1], [1, 0, -1], [1, 0, 1]]")
    void t2_2() {
        assertThat(new Solution().intersections(new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 0, 1}}))
                .isEqualTo(Set.of(Point.of(1, 1), Point.of(-1, 1)));
    }

    @Test
    @DisplayName("교점들 : [[1, -1, 0], [2, -1, 0], [4, -1, 0]]")
    void t2_3() {
        assertThat(new Solution().intersections(new int[][]{{1, -1, 0}, {2, -1, 0}, {4, -1, 0}}))
                .isEqualTo(Set.of(Point.of(0, 0)));
    }

    @Test
    @DisplayName("교점들 : [[2, -1, 4], [-2, -1, 4], [0, -1, 1], [5, -8, -12], [5, 8, 12]]")
    void t2_4() {
        assertThat(new Solution().intersections(new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}}))
                .isEqualTo(Set.of(Point.of(4, 1), Point.of(4, -4), Point.of(-4, -4), Point.of(-4, 1), Point.of(0, 4)));
    }

    @Test
    @DisplayName("minPoint, [Point.of(1, 1), Point.of(-1, 1)]")
    void t3() {
        assertThat(
                new Solution().getMinPoint(Set.of(Point.of(1, 1), Point.of(-1, 1)))
        ).isEqualTo(
                Point.of(-1, 1)
        );
    }

    @Test
    @DisplayName("minPoint, [Point.of(-5, 1), Point.of(-1, -7)]")
    void t3_2() {
        assertThat(
                new Solution().getMinPoint(Set.of(Point.of(-5, 1), Point.of(-1, -7)))
        ).isEqualTo(
                Point.of(-5, -7)
        );
    }

    @Test
    @DisplayName("maxPoint, [Point.of(1, 1), Point.of(-1, 1)]")
    void t4() {
        assertThat(
                new Solution().getMaxPoint(Set.of(Point.of(1, 1), Point.of(-1, 1)))
        ).isEqualTo(
                Point.of(1, 1)
        );
    }

    @Test
    @DisplayName("maxPoint, [Point.of(4, 1), Point.of(-1, 6)]")
    void t4_2() {
        assertThat(
                new Solution().getMaxPoint(Set.of(Point.of(4, 1), Point.of(-1, 6)))
        ).isEqualTo(
                Point.of(4, 6)
        );
    }

    @Test
    @DisplayName("emptyMatrix, [Point.of(1, 1), Point.of(-1, 1)]")
    void t5() {
        assertThat(
                new Solution().emptyMatrix(Set.of(Point.of(1, 1), Point.of(-1, 1)))
        ).isEqualTo(
                new char[][]{
                        {'.', '.', '.'}
                }
        );
    }

    @Test
    @DisplayName("emptyMatrix, [Point.of(4, -7), Point.of(-1, 6)]")
    void t5_2() {
        assertThat(
                new Solution().emptyMatrix(Set.of(Point.of(4, -7), Point.of(-1, 6)))
        ).isEqualTo(
                new char[][]{
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'}
                }
        );
    }

    @Test
    @DisplayName("positivePoints, [Point.of(1, 1), Point.of(-1, 1)]")
    void t6() {
        assertThat(
                new Solution().positivePoints(Set.of(Point.of(1, 1), Point.of(-1, 1)))
        ).isEqualTo(
                Set.of(Point.of(2, 0), Point.of(0, 0))
        );
    }

    @Test
    @DisplayName("positivePoints, [Point.of(4, -7), Point.of(-1, 6)]")
    void t6_2() {
        assertThat(
                new Solution().positivePoints(Set.of(Point.of(4, -7), Point.of(-1, 6)))
        ).isEqualTo(
                Set.of(Point.of(5, 0), Point.of(0, 13))
        );
    }
}
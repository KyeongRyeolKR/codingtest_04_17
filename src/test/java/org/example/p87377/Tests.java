package org.example.p87377;

import org.example.TestUt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class Tests {
    @Test
    @DisplayName("교점, [[1, -1, 0], [2, -1, 0]]")
    void t01() {
        assertThat(
                (Point) TestUt.call(
                        new Solution(),
                        "intersection",
                        new int[]{1, -1, 0},
                        new int[]{2, -1, 0}
                )
        ).isEqualTo(
                Point.of(0, 0)
        );
    }

    @Test
    @DisplayName("교점, [[1, -1, 0], [4, -1, 0]]")
    void t01_2() {
        assertThat(
                (Point) TestUt.call(
                        new Solution(),
                        "intersection",
                        new int[]{1, -1, 0},
                        new int[]{4, -1, 0}
                )
        ).isEqualTo(
                Point.of(0, 0)
        );
    }

    @Test
    @DisplayName("교점, [[2, -1, 0], [4, -1, 0]]")
    void t01_3() {
        assertThat(
                (Point) TestUt.call(
                        new Solution(),
                        "intersection",
                        new int[]{2, -1, 0},
                        new int[]{4, -1, 0}
                )
        ).isEqualTo(
                Point.of(0, 0)
        );
    }

    @Test
    @DisplayName("교점, [[0, 1, -1], [1, 0, -1]]")
    void t01_4() {
        assertThat(
                (Point) TestUt.call(
                        new Solution(),
                        "intersection",
                        new int[]{0, 1, -1},
                        new int[]{1, 0, -1}
                )
        ).isEqualTo(
                Point.of(1, 1)
        );
    }

    @Test
    @DisplayName("교점, [[0, 1, -1], [1, 0, 1]]")
    void t01_5() {
        assertThat(
                (Point) TestUt.call(
                        new Solution(),
                        "intersection",
                        new int[]{0, 1, -1},
                        new int[]{1, 0, 1}
                )
        ).isEqualTo(
                Point.of(-1, 1)
        );
    }

    @Test
    @DisplayName("교점들, [[1, -1, 0], [2, -1, 0]]")
    void t02() {
        assertThat(
                new Solution().intersections(
                        new int[][]{{0, 1, -1}, {1, 0, 1}}
                )
        ).isEqualTo(
                Points.of(Point.of(-1, 1))
        );
    }

    @Test
    @DisplayName("교점들, [[0, 1, -1], [1, 0, -1], [1, 0, 1]]")
    void t02_2() {
        assertThat(
                new Solution().intersections(
                        new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 0, 1}}
                )
        ).isEqualTo(
                Points.of(Point.of(1, 1), Point.of(-1, 1))
        );
    }

    @Test
    @DisplayName("교점들, [[1, -1, 0], [2, -1, 0], [4, -1, 0]]")
    void t02_3() {
        assertThat(
                new Solution().intersections(
                        new int[][]{{1, -1, 0}, {2, -1, 0}, {4, -1, 0}}
                )
        ).isEqualTo(
                Points.of(Point.of(0, 0))
        );
    }

    @Test
    @DisplayName("교점들, [[2, -1, 4], [-2, -1, 4], [0, -1, 1], [5, -8, -12], [5, 8, 12]]")
    void t02_4() {
        assertThat(
                new Solution().intersections(
                        new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}}
                )
        ).isEqualTo(
                Points.of(Point.of(4, 1), Point.of(4, -4), Point.of(-4, -4), Point.of(-4, 1), Point.of(0, 4))
        );
    }

    @Test
    @DisplayName("minPoint, [Point.of(1, 1), Point.of(-1, 1)]")
    void t03() {
        assertThat(
                (Point) TestUt.call(
                        Points.of(Point.of(1, 1), Point.of(-1, 1)),
                        "getMinPoint"
                )
        ).isEqualTo(
                Point.of(-1, 1)
        );
    }

    @Test
    @DisplayName("minPoint, [Point.of(-5, 1), Point.of(-1, -7)]")
    void t03_2() {
        assertThat(
                (Point) TestUt.call(
                        Points.of(Point.of(-5, 1), Point.of(-1, -7)),
                        "getMinPoint"
                )
        ).isEqualTo(
                Point.of(-5, -7)
        );
    }

    @Test
    @DisplayName("maxPoint, [Point.of(1, 1), Point.of(-1, 1)]")
    void t04() {
        assertThat(
                (Point) TestUt.call(
                        Points.of(Point.of(1, 1), Point.of(-1, 1)),
                        "getMaxPoint"
                )
        ).isEqualTo(
                Point.of(1, 1)
        );
    }

    @Test
    @DisplayName("maxPoint, [Point.of(4, 1), Point.of(-1, 6)]")
    void t04_2() {
        assertThat(
                (Point) TestUt.call(
                        Points.of(Point.of(4, 1), Point.of(-1, 6)),
                        "getMaxPoint"
                )
        ).isEqualTo(
                Point.of(4, 6)
        );
    }

    @Test
    @DisplayName("emptyMatrix, [Point.of(1, 1), Point.of(-1, 1)]")
    void t05() {
        assertThat(
                (char[][]) TestUt.call(
                        Points.of(Point.of(1, 1), Point.of(-1, 1)),
                        "emptyMatrix"
                )
        ).isEqualTo(
                new char[][]{
                        {'.', '.', '.'}
                }
        );
    }

    @Test
    @DisplayName("emptyMatrix, [Point.of(4, -7), Point.of(-1, 6)]")
    void t05_2() {
        assertThat(
                (char[][]) TestUt.call(
                        Points.of(Point.of(4, -7), Point.of(-1, 6)),
                        "emptyMatrix"
                )
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
    void t06() {
        assertThat(
                (Points) TestUt.call(
                        Points.of(Point.of(1, 1), Point.of(-1, 1)),
                        "positivePoints"
                )
        ).isEqualTo(
                Points.of(Point.of(2, 0), Point.of(0, 0))
        );
    }

    @Test
    @DisplayName("positivePoints, [Point.of(4, -7), Point.of(-1, 6)]")
    void t06_2() {
        assertThat(
                (Points) TestUt.call(
                        Points.of(Point.of(4, -7), Point.of(-1, 6)),
                        "positivePoints"
                )
        ).isEqualTo(
                Points.of(Point.of(5, 0), Point.of(0, 13))
        );
    }

    @Test
    @DisplayName("toMatrix, [Point.of(1, 1), Point.of(-1, 1)]")
    void t07() {
        assertThat(
                Points.of(Point.of(1, 1), Point.of(-1, 1)).toMatrix()
        ).isEqualTo(
                new char[][]{
                        {'*', '.', '*'}
                }
        );
    }

    @Test
    @DisplayName("toMatrix, [Point.of(4, -7), Point.of(-1, 6)]")
    void t07_2() {
        assertThat(
                Points.of(Point.of(4, -7), Point.of(-1, 6)).toMatrix()
        ).isEqualTo(
                new char[][]{
                        {'.', '.', '.', '.', '.', '*'},
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
                        {'*', '.', '.', '.', '.', '.'}
                }
        );
    }

    @Test
    @DisplayName("drawOnCoordinate, 1st")
    void t08() {
        assertThat(
                new Solution().drawOnCoordinate(
                        new char[][]{
                                {'*', '.'},
                                {'.', '*'},
                        }
                )
        ).isEqualTo(
                new String[]{
                        ".*",
                        "*."
                }
        );
    }

    @Test
    @DisplayName("drawOnCoordinate, 2nd")
    void t08_2() {
        assertThat(
                new Solution().drawOnCoordinate(
                        new char[][]{
                                {'.', '.', '.', '.', '.', '*'},
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
                                {'*', '.', '.', '.', '.', '.'}
                        }
                )
        ).isEqualTo(
                new String[]{
                        "*.....",
                        "......",
                        "......",
                        "......",
                        "......",
                        "......",
                        "......",
                        "......",
                        "......",
                        "......",
                        "......",
                        "......",
                        "......",
                        ".....*"
                }
        );
    }

    @Test
    @DisplayName("solution, [[1, -1, 0], [2, -1, 0]]")
    void t09() {
        assertThat(
                new Solution().solution(new int[][]{{1, -1, 0}, {2, -1, 0}})
        ).isEqualTo(
                new String[]{"*"}
        );
    }

    @Test
    @DisplayName("solution, [[1, -1, 0], [2, -1, 0], [4, -1, 0]]")
    void t09_2() {
        assertThat(
                new Solution().solution(new int[][]{{1, -1, 0}, {2, -1, 0}, {4, -1, 0}})
        ).isEqualTo(
                new String[]{"*"}
        );
    }

    @Test
    @DisplayName("solution, [[0, 1, -1], [1, 0, -1], [1, 0, 1]]")
    void t09_3() {
        assertThat(
                new Solution().solution(new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 0, 1}})
        ).isEqualTo(
                new String[]{"*.*"}
        );
    }

    @Test
    @DisplayName("solution, [[2, -1, 4], [-2, -1, 4], [0, -1, 1], [5, -8, -12], [5, 8, 12]]")
    void t09_4() {
        assertThat(
                new Solution().solution(new int[][]{
                        {2, -1, 4},
                        {-2, -1, 4},
                        {0, -1, 1},
                        {5, -8, -12},
                        {5, 8, 12}
                })
        ).isEqualTo(
                new String[]{
                        "....*....",
                        ".........",
                        ".........",
                        "*.......*",
                        ".........",
                        ".........",
                        ".........",
                        ".........",
                        "*.......*"
                }
        );
    }
}
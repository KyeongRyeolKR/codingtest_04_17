package org.example.p87377;

import java.util.stream.IntStream;

public class Ut {
    public static IntStream revRange(int from, int to) {
        return IntStream.range(from, to)
                .map(i -> to - i + from - 1);
    }
}
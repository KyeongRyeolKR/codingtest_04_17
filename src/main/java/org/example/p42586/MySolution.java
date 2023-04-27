package org.example.p42586;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * progresses	                speeds	                return
 * [93, 30, 55]	                [1, 30, 5]	            [2, 1]
 * [95, 90, 99, 99, 80, 99]	    [1, 1, 1, 1, 1, 1]	    [1, 3, 2]
 */
public class MySolution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = IntStream.range(0, progresses.length)
                .mapToObj(i -> (int) Math.ceil((100.0 - progresses[i]) / speeds[i]))
                .collect(Collectors.toCollection(LinkedList::new));

        List<Integer> result = new ArrayList<>();

        while(!queue.isEmpty()) {
            int remain = queue.poll();
            int count = 1;

            while(!queue.isEmpty() && remain >= queue.peek()) {
                queue.poll();
                count++;
            }

            result.add(count);
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        new MySolution().solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
    }

}

package org.example.p42840;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MySolution {
    public int[] solution(int[] answers) {
        List<Integer> a1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> a2 = Arrays.asList(2, 1, 2, 3, 2, 4, 2, 5);
        List<Integer> a3 = Arrays.asList(3, 3, 1, 1, 2, 2, 4, 4, 5, 5);

        int[] counts = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == a1.get(i%4)) counts[0]++;
            if (answers[i] == a2.get(i%7)) counts[1]++;
            if (answers[i] == a3.get(i%9)) counts[2]++;
        }

//        System.out.println(counts[0]);
//        System.out.println(counts[1]);
//        System.out.println(counts[2]);

        int max = -1;
        if (max < counts[0]) max = counts[0];
        else if (max < counts[1]) max = counts[1];
        else if (max < counts[2]) max = counts[2];

//        System.out.println(max);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == max) list.add(i + 1);
        }

        System.out.println(list);

        return list.stream()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        new MySolution().solution(new int[]{1,2,3,4,5});
    }
}

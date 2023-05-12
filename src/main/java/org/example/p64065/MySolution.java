package org.example.p64065;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *    "{{4,2,3},{3},{2,3,4,1},{2,3}}"     	[3, 2, 4, 1]
 */
public class MySolution {
    public int[] solution(String s) {
        List<String> answer_ = new ArrayList<>();

        s = s.substring(2, s.length()-2);
        String[] arr = Arrays.stream(s.split("\\},\\{"))
                .sorted(Comparator.comparingInt(String::length))
                .toArray(String[]::new);

        for(int i=0; i<arr.length; i++) {
            String[] temp = arr[i].split(",");
            for(int j=0; j<temp.length; j++) {
                if(!answer_.contains(temp[j])) {
                    answer_.add(temp[j]);
                }
            }
        }

        return answer_.stream()
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static void main(String[] args) {
        new MySolution().solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
    }
}

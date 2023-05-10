package org.example.p72412;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> scoresMap = buildScoresMap(info);

        int[] answer = new int[query.length];

        for (int i = 0; i < answer.length; i++) {

            int lastSpaceIndex = query[i].lastIndexOf(" "); // 가장 마지막으로 등장하는 공백의 인덱스 찾기

            String key = query[i].substring(0, lastSpaceIndex).replaceAll(" and ", " ");
            int count = Integer.parseInt(query[i].substring(lastSpaceIndex + 1));

            answer[i] = countBiggerThan(scoresMap.get(key), count);
        }

        return answer;
    }

    Map<String, List<Integer>> buildScoresMap(String[] info) {
        Map<String, List<Integer>> scoresMap = new HashMap<>();

        for (String infoRow : info) {
            String[] infoRowBits = infoRow.split(" ");

            String languageTypeCode = infoRowBits[0];
            String jobGroupTypeCode = infoRowBits[1];
            String careerTypeCode = infoRowBits[2];
            String foodTypeCode = infoRowBits[3];
            int score = Integer.parseInt(infoRowBits[4]);

            String[] languageTypeCodes = new String[]{"-", languageTypeCode};
            String[] jobGroupTypeCodes = new String[]{"-", jobGroupTypeCode};
            String[] careerTypeCodes = new String[]{"-", careerTypeCode};
            String[] foodTypeCodes = new String[]{"-", foodTypeCode};

            for (String languageTypeCode_ : languageTypeCodes) {
                for (String jobGroupTypeCode_ : jobGroupTypeCodes) {
                    for (String careerTypeCode_ : careerTypeCodes) {
                        for (String foodTypeCode_ : foodTypeCodes) {
                            String key = languageTypeCode_ + " " + jobGroupTypeCode_ + " " + careerTypeCode_ + " " + foodTypeCode_;

                            scoresMap.putIfAbsent(key, new ArrayList<>()); // key가 없으면 새로운 ArrayList를 value로 넣어줌
                            scoresMap.get(key).add(score);
                        }
                    }
                }
            }
        }

        // 정렬
        scoresMap.forEach((key, scores) -> scores.sort(Integer::compareTo));

        return scoresMap;
    }

    public List<String> getAllQueries() {
        String[] languageTypeCodes = new String[]{"-", "cpp", "java", "python"};
        String[] jobGroupTypeCodes = new String[]{"-", "backend", "frontend"};
        String[] careerTypeCodes = new String[]{"-", "junior", "senior"};
        String[] foodTypeCodes = new String[]{"-", "chicken", "pizza"};

        List<String> all = new ArrayList<>();

        for (String languageTypeCode : languageTypeCodes) {
            for (String jobGroupTypeCode : jobGroupTypeCodes) {
                for (String careerTypeCode : careerTypeCodes) {
                    for (String foodTypeCode : foodTypeCodes) {
                        all.add(languageTypeCode + " " + jobGroupTypeCode + " " + careerTypeCode + " " + foodTypeCode);
                    }
                }
            }
        }

        return all;
    }

    public int countBiggerThan(List<Integer> scores, int score) {
        if (scores == null) return 0;
        if (scores.isEmpty()) return 0;

        int left = 0;
        int right = scores.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2; // mid

            if (scores.get(mid) < score) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return scores.size() - left;
    }
}
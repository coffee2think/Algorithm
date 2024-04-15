package src.programmers.lv1.Q92334;

import java.util.*;

/**
 * Programmers Q92334 lv1
 * Problem name: 신고 결과 받기
 * link: https://school.programmers.co.kr/learn/courses/30/lessons/92334
 */

public class Main {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        int[] answer = {2, 1, 1, 0};

        int[] result = new Main().solution(id_list, report, k);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.equals(answer, result) ? "Correct!" : "Wrong..");
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> userIndex = new HashMap<>();
        Map<String, Set<String>> map = new HashMap<>();

        // 유저 인덱스 맵 생성
        for (int i = 0; i < id_list.length; i++) {
            userIndex.put(id_list[i], i);
        }

        // 신고 내용 맵 생성
        for (int i = 0; i < report.length; i++) {
            StringTokenizer st = new StringTokenizer(report[i]);
            String reporter = st.nextToken();
            String target = st.nextToken();

            // 처음 신고되었다면 Map에 엔트리 생성
            if (!map.containsKey(target)) {
                map.put(target, new HashSet<>());
            }

            map.get(target).add(reporter);
        }

        // 신고 횟수 체크
        for (String reported : map.keySet()) {
            Set<String> reporters = map.get(reported);

            // 정지 여부를 판단하여 메일 받은 횟수 카운트하기
            if (reporters.size() >= k) {
                for (String reporter : reporters) {
                    answer[userIndex.get(reporter)]++;
                }
            }
        }

        return answer;
    }
}

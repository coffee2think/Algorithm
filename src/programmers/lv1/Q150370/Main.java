package src.programmers.lv1.Q150370;

import java.util.*;

/**
 * Programmers Q150370 lv1
 * Problem name: 개인정보 수집 유효기간
 * link: https://school.programmers.co.kr/learn/courses/30/lessons/150370
 */

public class Main {
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        int[] answer = {1, 3};

        int[] result = new Main().solution(today, terms, privacies);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.equals(answer, result) ? "Correct!" : "Wrong..");
    }

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> termsMap = new HashMap<>();

        // 약관 종류별 기간을 일 단위로 변환하여 Map에 저장
        for (int i = 0; i < terms.length; i++) {
            String[] split = terms[i].split(" ");
            termsMap.put(split[0], Integer.parseInt(split[1]) * 28);
        }

        // 개인정보별 기간을 계산하여 유효기간을 초과한 경우 result에 추가
        for (int i = 0; i < privacies.length; i++) {
            String[] split = privacies[i].split(" ");
            int period = period(split[0], today);
            if (period >= termsMap.get(split[1])) {
                result.add(i + 1);
            }
        }

        // 리스트를 배열로 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    public int period(String from, String to) {
        StringTokenizer st = new StringTokenizer(from, ".");

        int fromYear = Integer.parseInt(st.nextToken());
        int fromMonth = Integer.parseInt(st.nextToken());
        int fromDay = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(to, ".");

        int toYear = Integer.parseInt(st.nextToken());
        int toMonth = Integer.parseInt(st.nextToken());
        int toDay = Integer.parseInt(st.nextToken());

        return (toDay - fromDay) + (toMonth - fromMonth) * 28 + (toYear - fromYear) * 12 * 28;
    }
}

package src.programmers.lv1.Q150370;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * link: https://school.programmers.co.kr/learn/courses/30/lessons/150370
 * date: 2024-04-15
 * reviewDate: 2025-10-10
 */

public class Main {
    public static void main(String[] args) {
        // given
        String[] today = {"2022.05.19", "2020.01.01"};
        String[][] terms = {{"A 6", "B 12", "C 3"}, {"Z 3", "D 5"}};
        String[][] privacies = {
                {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"},
                {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"}
        };
        int[][] answer = {{1, 3}, {1, 4, 5}};

        // when
        int cases = answer.length;
        int answerCount = 0;
        for (int i = 0; i < cases; i++) {
            if (Objects.deepEquals(solution2(today[i], terms[i], privacies[i]), answer[i])) {
                System.out.println((i + 1) + ". 정답입니다.");
                answerCount++;
            } else {
                System.out.println((i + 1) + ". 틀렸습니다.");
            }
        }

        // then
        System.out.printf("정답률 : %d / %d (%.1f%%)\n", answerCount, cases, ((double) answerCount / cases * 100));
    }

    // solved date: 2024-04-15
    public static int[] solution(String today, String[] terms, String[] privacies) {
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

    public static int period(String from, String to) {
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

    /**
     *  solved date: 2025-10-10
     *  [배운 점]
     *  - Integer.parseInt(intStr)과 Integer.intValue()의 차이
     *  - IntStream의 mapToint
     *  - 날짜 관련 클래스: LocalDate, DateTimeFormatter
     *  - 두 날짜 사이의 일 수 계산하는 방법 : ChronoUnit.DAYS.between(LocalDate, LocalDate)
     *  - 그외: Period, Duration 클래스
     *  - List<Integer>를 int[] 로 변환하는 방법
     *    (1) Stream API: Java 8 이후 권장 방식. 가독성 & 편리함. 오버헤드 있음. 대규모 성능 우위(병렬 처리)
     *        * Java 8 특징: 람다 표현식, 함수형 프로그래밍 스타일 도입
     *        * list.stream().mapToInt(Integer::intValue).toArray();
     *    (2) 반복문(for): Java 8 이전 방식. 전통적. 오버헤드 없음. 소규모 성능 우위
     *  [생각 메모]
     *  - LocalDate를 사용한 방식의 성능이 예전 풀이보다 성능이 굉장히 안 좋았음.
     *  - 성능을 최적화하기 위해, 단계별로 다양한 구현 방식을 작성하고, 조합했을 때 성능을 비교하는 웹 프로젝트를 만들어보면 어떨까?
     */
    public static int[] solution2(String today, String[] terms, String[] privacies) {
        StringTokenizer st = null;
        int[] termsMonths = new int[26];
        for (String term : terms) {
            st = new StringTokenizer(term);
            termsMonths[st.nextToken().charAt(0) - 'A'] = Integer.parseInt(st.nextToken());
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate parsedToday = LocalDate.parse(today, formatter);
        List<Integer> expired = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            st = new StringTokenizer(privacies[i]);
            LocalDate collectedDate = LocalDate.parse(st.nextToken(), formatter);
            char termsType = st.nextToken().charAt(0);

            LocalDate dueDate = collectedDate.plusMonths(termsMonths[termsType - 'A']).minusDays(1);
            if (parsedToday.isAfter(dueDate)) {
                expired.add(i + 1);
            }
        }
        System.out.println(expired);
        int[] expiredArray = new int[expired.size()];
        for (int i = 0; i < expired.size(); i++) {
            expiredArray[i] = expired.get(i);
        }
        return expiredArray;
    }
}

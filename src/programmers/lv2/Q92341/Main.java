package src.programmers.lv2.Q92341;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * date: 2024-04-25
 * source: https://school.programmers.co.kr/learn/courses/30/lessons/92341
 */

public class Main {
    private static final int MAX_TIME = convertMinute("23:59");

    public static void main(String[] args) {
        // given
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] answer = {14600, 34400, 5000};

        // when
        int[] result = new Main().solution(fees, records);

        // then
        System.out.println("result: " + Arrays.toString(result) + " is " + (Arrays.equals(result, answer) ? "Correct!" : "Wrong.."));
    }

    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> recordMap = new HashMap<>();
        Map<String ,Integer> timeMap = new HashMap<>();
        Map<String ,Integer> feeMap = new TreeMap<>();

        for (String record : records) {
            // 1. 기록 문자열 분리
            String[] splitRecord = record.split(" ");
            String time = splitRecord[0];
            String carNumber = splitRecord[1];
            String inOut = splitRecord[2];

            // 2. 입출차에 따른 처리
            if (inOut.equals("IN")) {
                recordMap.put(carNumber, convertMinute(time));
            } else {
                int gap = convertMinute(time) - recordMap.get(carNumber);
                timeMap.put(carNumber, timeMap.getOrDefault(carNumber, 0) + gap);
                recordMap.remove(carNumber);
            }
        }

        // 3. 출차하지 않은 차량 처리
        for (String carNumber : recordMap.keySet()) {
            int gap = MAX_TIME - recordMap.get(carNumber);
            timeMap.put(carNumber, timeMap.getOrDefault(carNumber, 0) + gap);
        }

        // 4. 요금 계산
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        for (String carNumber : timeMap.keySet()) {
            int totalTime = timeMap.get(carNumber);
            int exceedTime = Math.max(totalTime - baseTime, 0);
            int fee = baseFee + unitFee * (int)Math.ceil((double)exceedTime / unitTime);

            feeMap.put(carNumber, fee);
        }

        // 5. 정답 배열에 담아 리턴
        int[] answer = new int[feeMap.size()];
        int idx = 0;
        for (String carNumber : feeMap.keySet()) {
            answer[idx++] = feeMap.get(carNumber);
        }

        return answer;
    }

    public static int convertMinute(String time) {
        String[] timeSplit = time.split(":");
        return Integer.parseInt(timeSplit[0]) * 60 + Integer.parseInt(timeSplit[1]);
    }
}

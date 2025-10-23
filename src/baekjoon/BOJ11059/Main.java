package src.baekjoon.BOJ11059;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// link: https://www.acmicpc.net/problem/11059
// date: 2025-10-23
//
// < 배운점 >
// String의 length() 함수의 코드를 타고 들어갔다가 value.length >> coder() 라는 코드를 발견함
// 단순히 필드에 저장된 값을 리턴하는 것이 아닌 비트 연산자(>>)를 사용함.
// 자바스크립트에서는 Math.floor() 함수를 사용하는 대신, (숫자) >> 0 을 사용하면 해당 숫자의 소수점을 버리고 정수 부분만 남기는 최적화 방법으로 사용한다고 함
// 위의 value는 바이트배열(byte[])인데, 인코딩에 따라 저장하는 바이트 크기가 달라져 글자수를 연산하는 작업이 필요함(영어/숫자 -> 1바이트, 한글/한자 등 -> 2바이트)
// 즉, 한글 문자열의 경우 글자수를 세기 위해서는 바이트 크기의 1/2를 해줘야함. 그것을 비트연산으로 처리한 것
// → 2의 거듭제곱으로 나누는 연산을 할 때는 비트연산을 적극적으로 사용하는 것을 고려
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        String str = br.readLine();
        int strLen = str.length();

        // when
        int[] prefixSum = new int[strLen + 1];
        for (int i = 0; i < strLen; i++) {
            prefixSum[i + 1] = prefixSum[i] + (str.charAt(i) - '0');
        }

        int maxEvenRange = strLen >> 1 << 1; // == strLen / 2 * 2. 최대 짝수 길이
        int maxRange = 0;
        loop:
        for (int range = maxEvenRange; range > 0; range -= 2) {
            int half = range / 2;
            for (int left = 0; left <= strLen - range; left++) {
                int prevSum = prefixSum[left + half] - prefixSum[left];
                int nextSum = prefixSum[left + range] - prefixSum[left + half];
                if (prevSum == nextSum) {
                    maxRange = Math.max(range, maxRange);
                    break loop; // 범위가 넓은 것부터 내려오기 때문에 처음 발견한 것이 정답
                }
            }
        }

        // then
        System.out.println(maxRange);
        br.close();
    }
}

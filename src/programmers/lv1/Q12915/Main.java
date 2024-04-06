package src.programmers.lv1.Q12915;

import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // 랜덤 문자열을 생성하기 위한 변수
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        int n = new Random().nextInt(10);

        int maxTestSize = 1000000;
        int step = 1000;
        double[][] result = new double[maxTestSize / step][3]; // result : {{cnt, lambda, anonymous}, ...}
        int resultIdx = 0;

        // 랜덤 문자열 배열 생성
        String[] randomStringArray = new String[maxTestSize];
        for (int i = 0; i < randomStringArray.length; i++) {
            Random random = new Random();
            String generatedString = random.ints(leftLimit, rightLimit + 1)
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
            randomStringArray[i] = generatedString;
        }

        System.out.printf("%-10s %-15s %-15s\n", "cnt", "lambda", "anonymous");
        System.out.println("=".repeat(40));

        for (int size = step; size < maxTestSize; size += step) {
            long lambdaBefore = System.nanoTime();
            Arrays.toString(new LambdaSolution().solution(randomStringArray, n, size));
            long lambdaAfter = System.nanoTime();

            long anonymousBefore = System.nanoTime();
            Arrays.toString(new AnonymousInnerClassSolution().solution(randomStringArray, n, size));
            long anonymousAfter = System.nanoTime();

            System.out.printf("%-10d %8.3f ms\t  %8.3f ms\n", size, ((lambdaAfter - lambdaBefore) / 1000000.0), ((anonymousAfter - anonymousBefore) / 1000000.0));

            result[resultIdx][0] = size;
            result[resultIdx][1] = (lambdaAfter - lambdaBefore) / 1000000.0;
            result[resultIdx][2] = (anonymousAfter - anonymousBefore) / 1000000.0;
            resultIdx++;
        }

        // 결과 파일 저장
        try(FileOutputStream fout = new FileOutputStream("./result.txt")) {
            StringBuilder sb = new StringBuilder();

            sb.append("cnt\tlambda\tanonymous\n");
            for (double[] resultItem : result) {
                sb.append(resultItem[0])
                        .append("\t")
                        .append(resultItem[1])
                        .append("\t")
                        .append(resultItem[2])
                        .append("\n");
            }

            fout.write(sb.toString().getBytes());
            fout.flush();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

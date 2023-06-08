package AlgorithmTest.Baekjoon.BOJ20920;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> wordMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if(str.length() >= M)
                wordMap.put(str, wordMap.getOrDefault(str, 0) + 1);
        }

        List<String> wordList = new ArrayList<>(wordMap.keySet());

        wordList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int cnt1 = wordMap.get(o1);
                int cnt2 = wordMap.get(o2);

                if (cnt1 != cnt2)
                    return cnt2 - cnt1;
                else if (o1.length() != o2.length())
                    return o2.length() - o1.length();
                else
                    return o1.compareTo(o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String word : wordList) {
            sb.append(word + "\n");
        }
        System.out.println(sb);
        br.close();
    }
}
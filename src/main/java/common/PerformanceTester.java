package common;

public class PerformanceTester {
    public static void measureExecutionTime(Runnable task) {
        long startTime = System.nanoTime();

        try {
            task.run();
        } catch (Exception e) {
            System.err.println("실행 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        double durationInMs = duration / 1_000_000.0;
        double durationInSeconds = durationInMs / 1_000.0;

        System.out.println("\n--- 성능 측정 결과 ---");
        System.out.printf("실행 시간: %.3f ms (%.5f 초)\n", durationInMs, durationInSeconds);
        System.out.println("--------------------");
    }

    @FunctionalInterface
    public interface ThrowingSolvable {
        void solve() throws Exception;
    }

    public static void measure(ThrowingSolvable solvable) {
        StringBuilder sb = new StringBuilder();
        long startTime = System.nanoTime();

        try {
            solvable.solve();
        } catch(Exception e) {
            sb.append("\n--- 실행 중 오류 발생 ---")
                    .append("\n오류 유형: ").append(e.getClass().getName())
                    .append("\n메시지: ").append(e.getMessage()).append("\n");
            System.out.println(sb.toString());
            e.printStackTrace();
            System.err.println("------------------------");
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        double durationInMs = duration / 1_000_000.0;

        System.out.println("\n--- 성능 측정 결과 ---");
        System.out.printf("실행 시간: %.3f ms\n", durationInMs);
        System.out.println("--------------------");
    }
}

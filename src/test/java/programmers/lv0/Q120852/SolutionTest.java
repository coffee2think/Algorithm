package programmers.lv0.Q120852;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();
    private long start;

    private final int[] inputs = {12, 17, 420};
    private final int[][] expected = {
            {2, 3},
            {17},
            {2, 3, 5, 7}
    };

    @BeforeEach
    void beforeEach() {
        start = System.nanoTime();
    }

    @AfterEach
    void afterEach() {
        long elapsed = System.nanoTime() - start;
        System.out.printf("%.3f ms%n", elapsed / 1_000_000.0);
    }

    @Test
    void solution1Test() {
        for (int i = 0; i < inputs.length; i++) {
            assertArrayEquals(
                    expected[i],
                    solution.solution1(inputs[i]),
                    "실패한 입력값: " + inputs[i]
            );
        }
    }
}
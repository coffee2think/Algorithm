import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import programmers.lv0.Q120852.Solution;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ScratchTest {

//    private Main main = new Main();
    private Solution solution = new Solution();
    private long start;

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
    void example1() {
        int[] inputs = {12, 17, 420};
        int[][] expected = {
                {2, 3},
                {17},
                {2, 3, 5, 7}
        };

        assertArrayEquals(expected[0], solution.solution1(inputs[0]));
    }

}

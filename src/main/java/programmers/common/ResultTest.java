package programmers.common;

public class ResultTest {
    public void printResult(int result, int answer){
        System.out.println("result: " + result + " is " + ((result == answer) ? "Correct!" : "Wrong.."));
    }
}

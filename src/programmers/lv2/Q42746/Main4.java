package src.programmers.lv2.Q42746;

public class Main4 {
    private int[] pow10;

    public static void main(String[] args) {
        // given
        int[][] numbers = {
                {6, 10, 2},
                {30, 3, 34, 5, 9},
                {979, 97, 978, 81, 818, 817},
                {0, 0, 0, 0, 0}
        };

        String[] answer = {
                "6210",
                "9534330",
                "9799797881881817",
                "0"
        };

        // when
        String[] result = new String[answer.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new Main().solution(numbers[i]);
        }

        // then
        for (int i = 0; i < result.length; i++) {
            System.out.println("result: " + result[i] + " is " + ((result[i].equals(answer[i])) ? "Correct!" : "Wrong.."));
        }
    }

    // 퀵정렬 직접 구현
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        powInit(4);

        quickSort(numbers, 0, numbers.length - 1);

        if (numbers[0] == 0) {
            return "0";
        }

        for (int n : numbers) {
            sb.append(n);
        }

        return sb.toString();
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (compare(arr[j], pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    public int compare(int n1, int n2) {
        int case1 = numConcat(n1, n2); // "n1" + "n2"
        int case2 = numConcat(n2, n1); // "n2" + "n1"
        return case2 - case1;
    }

    public int numConcat(int n1, int n2) {
        int digit2 = (n2 == 0) ? 0 : (int)Math.log10(n2);
        return n1 * pow10[digit2 + 1] + n2;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void powInit(int size) {
        pow10 = new int[size + 1];
        pow10[0] = 1;
        for (int i = 1; i < pow10.length; i++) {
            pow10[i] = pow10[i - 1] * 10;
        }
    }
}

package bug.free.broccoli.algoexpert;

import java.util.Arrays;

public class Ae10 {

    public static int[] findThreeLargestNumbers(int[] array) {
        int[] result = {-2 ^ 31 - 1, -2 ^ 31 - 1, -2 ^ 31 - 1};
        for (int k : array) {
            if (k >= result[0]) {
                result[0] = k;
                sort(result);
            }
        }
        return result;
    }

    private static void sort(int[] ar) {
        for (int i = 0; i < ar.length - 1; i++) {
            if (ar[i] > ar[i + 1]) {
                int tmp = ar[i];
                ar[i] = ar[i + 1];
                ar[i + 1] = tmp;
            } else
                break;
        }
    }

    public static void main(String[] args) {
        int[] input = {-1, -2, -3, -7, -17, -27, -18, -541, -8, -7, 7};
        Arrays.stream(findThreeLargestNumbers(input)).forEach(System.out::println);
    }
}

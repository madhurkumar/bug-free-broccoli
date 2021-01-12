package bug.free.broccoli.algoexpert;

import java.util.Arrays;

public class AeM2 {
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        int[] result = {0, 0, Integer.MAX_VALUE};
        for (int k : arrayOne) {
            for (int i : arrayTwo) {
                int diff = Math.abs(k - i);
                if (diff < result[2]) {
                    result = new int[]{k, i, diff};
                }
            }
        }
        return new int[]{result[0], result[1]};
    }

    public static void main(String[] args) {
        Arrays.stream(smallestDifference(new int[]{-1, 5, 10, 20, 28, 3}, new int[]{26, 134, 135, 15, 17})).forEach(System.out::println);
    }
}

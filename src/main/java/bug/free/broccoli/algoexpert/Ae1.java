package bug.free.broccoli.algoexpert;

import java.util.Arrays;
import java.util.stream.Collectors;

class Ae1 {
    public static int[] twoNumberSum(int[] array, int targetSum) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == targetSum)
                    return new int[]{array[i], array[j]};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.stream(
                        twoNumberSum(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 19))
                        .boxed()
                        .map(String::valueOf)
                        .collect(Collectors.joining(",")
                        )
        );
    }
}


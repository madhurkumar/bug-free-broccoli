package bug.free.broccoli.algoexpert;

import java.util.Arrays;

public class AeH3 {

    // how to do this in O(n)?
    public static int[] largestRange(int[] array) {
        Arrays.sort(array);
        int[] range = new int[]{0, 0};
        int start = 0;
        int end = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] + 1 == array[i + 1] || array[i + 1] == array[i]) {
                end = i + 1;
            } else {
                if (array[range[1]] - array[range[0]] < array[end] - array[start]) {
                    range = new int[]{start, end};
                }
                if (array[range[1]] - array[range[0]] > array[array.length - 1] - array[i + 1]) break;
                start = i + 1;
            }
            if (i == array.length - 2 && array[range[1]] - array[range[0]] < array[end] - array[start]) {
                range = new int[]{start, end};
            }
        }
        return new int[]{array[range[0]], array[range[1]]};
    }

    public static void main(String[] args) {
        Arrays.stream(largestRange(new int[]{1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6})).forEach(System.out::println);
        Arrays.stream(largestRange(new int[]{1, 2})).forEach(System.out::println);
        Arrays.stream(largestRange(new int[]{1, 1, 1, 3, 4})).forEach(System.out::println);
        Arrays.stream(largestRange(new int[]{19,
                -1,
                18,
                17,
                2,
                10,
                3,
                12,
                5,
                16,
                4,
                11,
                8,
                7,
                6,
                15,
                12,
                12,
                2,
                1,
                6,
                13,
                14})).forEach(System.out::println);
    }

}

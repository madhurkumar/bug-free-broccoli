package bug.free.broccoli.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AeH1 {

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        List<Integer[]> results = new ArrayList<>();
        for (int i = 0; i < array.length - 3; i++) {
            List<Integer[]> r = threeNumSum(Arrays.copyOfRange(array, i + 1, array.length), targetSum - array[i]);
            for (Integer[] a : r) {
                results.add(new Integer[]{array[i], a[0], a[1], a[2]});
            }

        }
        return results;
    }

    public static List<Integer[]> threeNumSum(int[] array, int targetSum) {
        List<Integer[]> results = new ArrayList<>();
        for (int i = 0; i < array.length - 2; i++)
            for (int j = i + 1; j < array.length - 1; j++)
                for (int k = j + 1; k < array.length; k++) {
                    if (array[i] + array[j] + array[k] == targetSum) {
                        results.add(new Integer[]{array[i], array[j], array[k]});
                    }
                }
        return results;
    }

    public static void main(String[] args) {
        int[] input = {5, -5, -2, 2, 3, -3};
        fourNumberSum(input, 0).forEach(s -> System.out.println(Arrays.stream(s).map(String::valueOf)
                .collect(Collectors.joining(","))));
    }
}

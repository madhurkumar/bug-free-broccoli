package bug.free.broccoli.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AeM1 {
    //O(n^3), possible solution with O(n^2)
    // Using counter to move index from right and left in same loop
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        List<Integer[]> results = new ArrayList<>();
        int[] sortedArray = sort(array);
        for (int i = 0; i < sortedArray.length - 2; i++)
            for (int j = i + 1; j < sortedArray.length - 1; j++)
                for (int k = j + 1; k < sortedArray.length; k++) {
                    if (sortedArray[i] + sortedArray[j] + sortedArray[k] == targetSum) {
                        results.add(new Integer[]{sortedArray[i], sortedArray[j], sortedArray[k]});
                    }
                }
        return results;
    }

    public static List<Integer[]> threeNumberSum2(int[] array, int targetSum) {
        List<Integer[]> results = new ArrayList<>();
        int[] sortedArray = sort(array);
        for (int i = 0; i < sortedArray.length - 2; i++) {
            int l = i + 1;
            int r = sortedArray.length - 1;
            while (l < r) {
                int iSum = sortedArray[i] + sortedArray[l] + sortedArray[r];
                if (iSum == targetSum) {
                    results.add(new Integer[]{sortedArray[i], sortedArray[l], sortedArray[r]});
                    r--;
                    l++;
                } else if (iSum > targetSum) r--;
                else l++;
            }
        }
        return results;
    }

    private static int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] input = {12, 3, 1, 2, -6, 5, -8, 6};
        threeNumberSum2(input, 0).forEach(s -> System.out.println(Arrays.stream(s).map(String::valueOf)
                .collect(Collectors.joining(","))));
    }
}

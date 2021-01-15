package bug.free.broccoli.algoexpert;

import java.util.Arrays;
import java.util.stream.Collectors;

public class AeH4 {
    public static int minRewards(int[] scores) {
        int max = 0;
        int[] result = new int[scores.length - 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = scores[i + 1] - scores[i];
        }
        System.out.println(Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(",")));
        //return Arrays.stream(result).map(l -> l + m).sum();
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(minRewards(new int[]{8, 4, 2, 1, 3, 6, 7, 9, 5}));
    }
}

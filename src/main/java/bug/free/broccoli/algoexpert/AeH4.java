package bug.free.broccoli.algoexpert;

import java.util.Arrays;
import java.util.stream.Collectors;

public class AeH4 {
    public static int minRewards(int[] scores) {
        System.out.println("==>" + Arrays.stream(scores).boxed().map(String::valueOf).collect(Collectors.joining(",")));
        int index = 0;
        int sum = 0;
        boolean asc = scores[0] <= scores[1];
        for (int i = 1; i <= scores.length; i++) {
            boolean upward = ((i == scores.length) || (scores[i - 1] > scores[i])) && asc;
            if (upward) {
                int counter = index == 0 ? 1 : 2;
                for (int j = index; j < i; j++) {
                    sum += scores[j] = counter++;
                }
                asc = false;
                index = i;
            }
            boolean downward = ((i == scores.length) || (scores[i - 1] < scores[i])) && !asc;
            if (downward) {
                int counter = i - index;
                for (int j = index; j < i; j++) {
                    sum += scores[j] = counter--;
                }
                asc = true;
                index = i;
            }
        }
        System.out.println("==>" + Arrays.stream(scores).boxed().map(String::valueOf).collect(Collectors.joining(",")));
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(minRewards(new int[]{8, 4, 2, 1, 3, 6, 7, 9, 5}));
        System.out.println(minRewards(new int[]{0, 4, 2, 1, 3}));
    }
}

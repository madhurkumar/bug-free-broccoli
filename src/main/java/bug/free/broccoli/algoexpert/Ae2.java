package bug.free.broccoli.algoexpert;

import java.util.Arrays;
import java.util.List;

public class Ae2 {

    //not efficient, could be done in single iteration
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int index = -1;
        for (Integer s : sequence) {
            int currentIndex = -1;
            for (int i = index + 1; i < array.size(); i++) {
                if (array.get(i).intValue() == s.intValue()) {
                    currentIndex = i;
                    break;
                }
            }
            if (currentIndex < 0) return false;
            index = currentIndex;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(
                isValidSubsequence(
                        Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10),
                        Arrays.asList(1, 6, -1, 22)
                ));
    }
}

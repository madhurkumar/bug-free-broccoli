package bug.free.broccoli.algoexpert;

import java.util.HashSet;
import java.util.Set;

public class AeM7 {

    public int firstDuplicateValue(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < array.length - 1; i++) {
            if (seen.contains(array[i])) return array[i];
            else seen.add(array[i]);
        }
        return -1;
    }

    public static void main(String[] args) {
        AeM7 aeM7 = new AeM7();
        System.out.println(aeM7.firstDuplicateValue(new int[]{2, 1, 5, 2, 3, 3, 4}));
    }
}

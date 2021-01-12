package bug.free.broccoli.algoexpert;

import java.util.Arrays;
import java.util.List;

public class AeM3 {
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        Integer[] a = array.toArray(Integer[]::new);
        int right = 0;
        int left = a.length - 1;
        while (right < left) {
            if (a[right] == toMove && a[left] != toMove) {
                int tmp = a[left];
                a[left] = a[right];
                a[right] = tmp;
                right++;
            }
            if (a[right] != toMove) right++;
            if (a[left] == toMove) left--;
        }
        return Arrays.asList(a);
    }

    public static void main(String[] args) {
        moveElementToEnd(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2), 2).forEach(System.out::println);
    }
}

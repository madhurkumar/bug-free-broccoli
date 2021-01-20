package bug.free.broccoli.algoexpert;

import java.util.Arrays;

public class AeM10 {
    public int[] threeNumberSort(int[] array, int[] order) {
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (isSwappable(order, array[i], array[j])) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        return array;
    }

    private boolean isSwappable(int[] order, int x, int y) {
        int i = x == order[0] ? 0 : x == order[1] ? 1 : 2;
        int j = y == order[0] ? 0 : y == order[1] ? 1 : 2;
        return i > j;
    }

    public static void main(String[] args) {
        AeM10 aeM10 = new AeM10();
        Arrays.stream(aeM10.threeNumberSort(new int[]{1, 0, 0, -1, -1, 0, 1, 1}, new int[]{0, 1, -1})).forEach(System.out::println);
    }
}

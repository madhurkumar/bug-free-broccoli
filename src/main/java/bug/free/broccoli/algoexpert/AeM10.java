package bug.free.broccoli.algoexpert;

import java.util.Arrays;

public class AeM10 {
    //O(n^2)
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

    //O(n)
    public int[] threeNumberSort1(int[] array, int[] order) {
        int[] counts = new int[]{0, 0, 0};
        for (int value : array) {
            int k = findIndex(value, order);
            if (k != -1) counts[k] += 1;
        }
        int start = 0;
        for (int j = 0; j < order.length; j++) {
            int index = 0;
            while (index < counts[j]) {
                array[start + index] = order[j];
                index++;
            }
            start += counts[j];
        }
        return array;
    }

    private int findIndex(int input, int[] order) {
        for (int i = 0; i < order.length; i++) {
            if (order[i] == input) return i;
        }
        return -1;
    }

    private boolean isSwappable(int[] order, int x, int y) {
        int i = x == order[0] ? 0 : x == order[1] ? 1 : 2;
        int j = y == order[0] ? 0 : y == order[1] ? 1 : 2;
        return i > j;
    }

    public static void main(String[] args) {
        AeM10 aeM10 = new AeM10();
        Arrays.stream(aeM10.threeNumberSort1(new int[]{1, 0, 0, -1, -1, 0, 1, 1}, new int[]{0, 1, -1})).forEach(System.out::println);
    }
}

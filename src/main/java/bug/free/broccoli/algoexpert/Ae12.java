package bug.free.broccoli.algoexpert;

import java.util.Arrays;

public class Ae12 {
    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
        return array;
    }

    public static void main(String[] args) {
        Arrays.stream(insertionSort(new int[]{8, 5, 2, 9, 5, 6, 3})).forEach(System.out::println);
    }
}

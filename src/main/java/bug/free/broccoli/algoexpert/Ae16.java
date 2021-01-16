package bug.free.broccoli.algoexpert;

import java.util.Arrays;

public class Ae16 {

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int tmp = array[min];
            array[min] = array[i];
            array[i] = tmp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] input = new int[]{8, 5, 2, 9, 5, 6, 3};
        Arrays.stream(selectionSort(input)).forEach(System.out::println);
    }
}

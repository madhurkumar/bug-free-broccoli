package bug.free.broccoli.algoexpert;

import java.util.Arrays;

public class AeH5 {

    public static void main(String[] args) {
        Arrays.stream(heapSort(new int[]{8, 5, 2, 9, 5, 6, 3})).forEach(System.out::println);
    }

    public static void heapify(int[] array, int size, int root) {
        int largest = root;
        int left = root * 2 + 1;
        int right = root * 2 + 2;
        if (left < size && array[largest] < array[left]) largest = left;
        if (right < size && array[largest] < array[right]) largest = right;
        if (largest != root) {
            int tmp = array[root];
            array[root] = array[largest];
            array[largest] = tmp;
            heapify(array, size, largest);
        }
    }

    public static int[] heapSort(int[] array) {
        int l = array.length / 2 - 1;
        for (int i = l; i >= 0; i--) {
            heapify(array, array.length, i);
        }
        for (int i = array.length - 1; i > 0; i--) {
            int tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;
            heapify(array, i, 0);
        }
        return array;
    }
}

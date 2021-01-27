package bug.free.broccoli.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AeM14 {
    static class MinHeap {
        List<Integer> heap;

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> array) {
            int l = array.size() / 2 - 1;
            for (int i = l; i >= 0; i--) {
                heapify(array, array.size(), i);
            }
            return new ArrayList<>(array);
        }

        public static void heapify(List<Integer> array, int size, int root) {
            int smallest = root;
            int left = root * 2 + 1;
            int right = root * 2 + 2;
            if (left < size && array.get(smallest) > array.get(left)) smallest = left;
            if (right < size && array.get(smallest) > array.get(right)) smallest = right;
            if (smallest != root) {
                int tmp = array.get(root);
                array.set(root, array.get(smallest));
                array.set(smallest, tmp);
                heapify(array, size, smallest);
            }
        }
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(
                Arrays.asList(48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41));
        System.out.println(minHeap.heap.stream().map(String::valueOf).collect(Collectors.joining(",")));
    }
}

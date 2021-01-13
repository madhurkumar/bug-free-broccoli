package bug.free.broccoli.algoexpert;

import java.util.Arrays;

public class AeH2 {

    //can be done in O(n)
    public static int[] subarraySort(int[] array) {
        int lowest = array.length - 1;
        int highest = 0;
        boolean atLeastOneSort = false;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    atLeastOneSort = true;
                    if (j < lowest) lowest = j;
                    if (j + 1 > highest) highest = j + 1;
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return atLeastOneSort ? new int[]{lowest, highest} : new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Arrays.stream(subarraySort(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19})).forEach(System.out::println);
    }


}

package bug.free.broccoli.algoexpert;

public class Ae9 {

    public static int binarySearch(int[] array, int target) {
        return bs(array, 0, array.length - 1, target);
    }

    private static int bs(int[] array, int low, int high, int target) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (array[mid] == target) return mid;
        return array[mid] > target ? bs(array, low, mid - 1, target) : bs(array, mid + 1, high, target);
    }

    public static void main(String[] args) {
        int[] input = {1, 5, 23, 111};
        System.out.println(binarySearch(input, 120));
    }

}

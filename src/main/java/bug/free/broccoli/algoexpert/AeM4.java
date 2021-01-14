package bug.free.broccoli.algoexpert;

public class AeM4 {
    public static boolean isMonotonic(int[] array) {
        boolean asc = true;
        boolean desc = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] < array[i]) asc = false;
            if (array[i + 1] > array[i]) desc = false;
        }
        return asc || desc;
    }

    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{-1, -5, -10, -1100, -1100, -1101, -1102, -9001}));
    }
}

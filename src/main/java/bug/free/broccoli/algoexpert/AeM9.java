package bug.free.broccoli.algoexpert;

import java.util.Arrays;

public class AeM9 {

    public int[] arrayOfProducts(int[] array) {
        int product = 1;
        int countOfZero = 0;
        for (int a : array) {
            if (a == 0) countOfZero++;
            if (countOfZero > 1) product = 0;
            else
                product *= a == 0 ? 1 : a;
        }
        for (int i = 0; i < array.length; i++) {
            if (countOfZero == 1) {
                if (array[i] == 0)
                    array[i] = product;
                else
                    array[i] = 0;
            } else
                array[i] = array[i] != 0 ? product / array[i] : array[i];
        }
        return array;
    }

    public static void main(String[] args) {
        AeM9 aeM9 = new AeM9();
        Arrays.stream(aeM9.arrayOfProducts(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9})).forEach(System.out::println);
    }
}

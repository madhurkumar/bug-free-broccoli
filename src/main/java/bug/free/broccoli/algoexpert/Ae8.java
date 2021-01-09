package bug.free.broccoli.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ae8 {
    public static int productSum(List<Object> array) {
        return ps(array, 1);
    }

    @SuppressWarnings("unchecked")
    private static int ps(List<Object> array, int level) {
        int result = 0;
        for (Object o : array) {
            if (o instanceof ArrayList) {
                result += ps((List<Object>) o, level + 1);
            }
            if (o instanceof Integer)
                result += (Integer) o;
        }
        return level * result;
    }

    public static void main(String[] args) {
        List<Object> i = Arrays.asList(7, -1);
        List<Object> j = Arrays.asList(-13, 8);
        List<Object> k = Arrays.asList(6, j, 4);
        List<Object> input = Arrays.asList(5, 2, i, 3, k);
        System.out.println(productSum(input));
    }
}

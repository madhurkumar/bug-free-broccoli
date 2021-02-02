package bug.free.broccoli.algoexpert;

import java.util.ArrayList;
import java.util.Collections;

public class Buildings {

    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        ArrayList<Integer> v = new ArrayList<>();
        int step = "EAST".equals(direction) ? -1 : 1;
        int index = "EAST".equals(direction) ? buildings.length - 1 : 0;
        int last = 0;
        while (index < buildings.length && index >= 0) {
            if (buildings[index] > last) {
                last = buildings[index];
                v.add(index);
            }
            index = index + step;
        }
        Collections.sort(v);
        return v;
    }

    public static void main(String[] args) {
        Buildings buildings = new Buildings();
        System.out.println(buildings.sunsetViews(new int[]{3, 5, 4, 4, 3, 1, 3, 2}, "EAST"));
    }
}

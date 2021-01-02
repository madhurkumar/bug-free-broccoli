package bug.free.broccoli;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TickTick {


    private static double hourHand(int hours, int mins) {
        return 30.0 * (hours + (mins / 60.0));
    }

    private static double minuteHand(int mins) {
        return 6.0 * mins;
    }


    public static void main(String[] args) {
        String time = "3:30";
        List<Integer> values = Arrays.stream(time.split(":"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        assert (values.size() == 2);
        double hh = hourHand(values.get(0), values.get(1));
        System.out.println("Hour hand angle from start => " + hh);
        double mh = minuteHand(values.get(1));
        System.out.println("Minute hand angle from start => " + mh);
        System.out.println("Angle diff between hands => " + (hh > mh ? hh - mh : mh - hh));
    }

}

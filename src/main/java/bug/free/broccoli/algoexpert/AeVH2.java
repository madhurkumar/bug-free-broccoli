package bug.free.broccoli.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class AeVH2 {
    public static List<StringMeeting> calendarMatching(
            List<StringMeeting> calendar1,
            StringMeeting dailyBounds1,
            List<StringMeeting> calendar2,
            StringMeeting dailyBounds2,
            int meetingDuration) {
        parseDailyBound(dailyBounds1, dailyBounds2, meetingDuration);
        return new ArrayList<>();
    }

    private static Integer[] parseDailyBound(StringMeeting dailyBounds1, StringMeeting dailyBounds2, int meetingDuration) {
        Integer[] start1 = Arrays.stream(dailyBounds1.start.split(":")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] end1 = Arrays.stream(dailyBounds1.end.split(":")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] start2 = Arrays.stream(dailyBounds2.start.split(":")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] end2 = Arrays.stream(dailyBounds2.end.split(":")).map(Integer::parseInt).toArray(Integer[]::new);
        int startHour = Math.max(start1[0], start2[0]);
        int startMinute = Math.max(start1[1], start2[1]);
        int endHour = Math.min(end1[0], end2[0]);
        int endMinute = Math.min(end1[1], end2[1]);
        int noOfMeetingSlots = ((endHour - startHour) * 60) / meetingDuration + (endMinute - startMinute) / meetingDuration;
        return IntStream
                .rangeClosed(0, noOfMeetingSlots)
                .map(i -> startHour * 100 + 100 * ((meetingDuration * i) / 60) + (meetingDuration * i) % 60)
                .boxed()
                .toArray(Integer[]::new);
    }

    static class StringMeeting {
        public String start;
        public String end;

        public StringMeeting(String start, String end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        calendarMatching(
                null, new StringMeeting("9:00", "20:00"),
                null, new StringMeeting("10:00", "18:00"),
                30);
    }

}

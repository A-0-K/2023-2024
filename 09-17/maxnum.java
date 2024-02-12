import java.io.*;
import java.util.*;

public class maxnum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new  FileReader("10.in"));
        int N = Integer.parseInt(reader.readLine());
        Event[] events = new Event[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            events[i] = new Event(start, end);
        }

        int maxEvents = findMaxEvents(events);
        System.out.println(maxEvents);
        reader.close();
    }

    public static int findMaxEvents(Event[] events) {
        // Sort events by their start times in ascending order
        Arrays.sort(events, (a, b) -> Integer.compare(a.start, b.start));

        int maxEvents = 0;
        boolean[] availableDays = new boolean[1000001]; // Array to track available days

        for (Event event : events) {
            for (int day = event.start; day <= event.end; day++) {
                if (!availableDays[day]) {
                    maxEvents++;
                    availableDays[day] = true;
                    break;
                }
            }
        }

        return maxEvents;
    }
}

class Event {
    int start;
    int end;

    public Event(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
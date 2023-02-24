import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // Läs in resten av raden efter n

        List<Event> events = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+"); // Dela upp raden i delar

            // Skapa en ny händelse med månad, dag, tid och beskrivning
            Event event = new Event(parts[0], Integer.parseInt(parts[1]), parts[2], parts[3]);

            events.add(event);
        }

        // Sortera händelserna efter tidpunkt (och sedan datum om tiden är densamma)
        Collections.sort(events);

        // Skriv ut händelserna i tidsordning
        for (Event event : events) {
            System.out.println(event);
        }
    }
}

class Event implements Comparable<Event> {
    private static final Map<String, Integer> MONTHS = new HashMap<>(); // Månadernas namn och nummer
    static {
        MONTHS.put("jan", 1);
        MONTHS.put("feb", 2);
        MONTHS.put("mar", 3);
        MONTHS.put("apr", 4);
        MONTHS.put("maj", 5);
        MONTHS.put("jun", 6);
        MONTHS.put("jul", 7);
        MONTHS.put("aug", 8);
        MONTHS.put("sep", 9);
        MONTHS.put("okt", 10);
        MONTHS.put("nov", 11);
        MONTHS.put("dec", 12);
    }

    private int month;
    private int day;
    private String time;
    private String description;

    public Event(String monthName, int day, String time, String description) {
        this.month = MONTHS.get(monthName);
        this.day = day;
        this.time = time;
        this.description = description;
    }

    @Override
    public int compareTo(Event other) {
        // Jämför först tiden, sedan datumet
        int timeCompare = this.time.compareTo(other.time);
        if (timeCompare != 0) {
            return timeCompare;
        } else {
            return Integer.compare(this.month * 100 + this.day, other.month * 100 + other.day);
        }
    }

    @Override
    public String toString() {
        return String.format("%s %d %s %s", monthName(), day, time, description);
    }

    private String monthName() {
        for (Map.Entry<String, Integer> entry : MONTHS.entrySet()) {
            if (entry.getValue() == month) {
                return entry.getKey();
            }
        }
        return null; // Detta borde inte hända
    }
}

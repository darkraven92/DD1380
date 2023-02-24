import java.util.*;

public class WindowCoverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        // Skapa en lista med alla fönster
        List<Window> windows = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            windows.add(new Window(x1, y1, x2, y2));
        }
        
        // Sortera fönstren efter nedre vänstra hörnets x-koordinat
        Collections.sort(windows, new Comparator<Window>() {
            public int compare(Window w1, Window w2) {
                return Integer.compare(w1.x1, w2.x1);
            }
        });
        
        // Gå igenom alla fönster och räkna ut hur mycket yta de täcker
        int totalArea = 0;
        int rightMost = 0; // Den högsta x-koordinaten som täcks av något fönster
        for (Window w : windows) {
            if (w.x1 > rightMost) {
                // Inga fönster till vänster täcker denna yta
                totalArea += (w.x1 - rightMost) * 10000;
                rightMost = w.x1;
            }
            if (w.x2 > rightMost) {
                // Detta fönster täcker en del av ytan till höger om tidigare fönster
                totalArea += (w.x2 - rightMost) * 10000;
                rightMost = w.x2;
            }
            int height = w.y2 - w.y1;
            totalArea += height * (w.x2 - w.x1);
        }
        
        System.out.println(totalArea);
    }
    
    // En inre klass som representerar ett fönster
    static class Window {
        int x1, y1, x2, y2;
        public Window(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
}

import java.util.Scanner;

public class Quadrant {
    
    // Returnerar namnet på rutan som ligger steg right steg höger och up steg upp från given ruta
    public static String move(String name, int right, int up) {
        // Konvertera namnet till en sekvens av koordinater
        String[] coords = name.split("\\.");
        int x = Integer.parseInt(coords[0]);
        int y = Integer.parseInt(coords[1]);
        int size = (int) Math.pow(2, coords.length - 1); // storlek på rutnätet

        // Flytta steg right steg höger och up steg upp
        x += right;
        y -= up;

        // Kolla om den nya positionen är utanför rutnätet
        if (x < 1 || x > size || y < 1 || y > size) {
            return "outside";
        }

        // Konvertera tillbaka till namn på ruta
        String newName = "";
        for (int i = coords.length - 1; i >= 0; i--) {
            int qSize = (int) Math.pow(2, i);
            int qx = (x - 1) / qSize + 1;
            int qy = (y - 1) / qSize + 1;
            newName = qx + "." + qy + "." + newName;
            x = (x - 1) % qSize + 1;
            y = (y - 1) % qSize + 1;
        }
        return newName.substring(0, newName.length() - 1); // ta bort sista punkten
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        int right = sc.nextInt();
        int up = sc.nextInt();
        System.out.println(move(name, right, up));
    }
}


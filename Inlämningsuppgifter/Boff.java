import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int boffCount = 0;

        for (int i = start; i <= end; i++) {
            if (i % n == 0 || i % 10 == n) {
                boffCount++;
            }
        }

        System.out.println(boffCount);
    }
}

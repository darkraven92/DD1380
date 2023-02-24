import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Arrays.sort(nums);

        int sum = 0;
        int numCount = (n % 2 == 0) ? 2 : 1; // antalet största tal att summera
        for (int i = n - 1; i >= n - numCount; i--) {
            sum += nums[i];
        }

        System.out.println(sum);
    }
}

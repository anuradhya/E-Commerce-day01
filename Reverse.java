import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        scanner.close();

        int mid = (n + 1) / 2; // Find the middle position

        for (int i = 1; i <= n; i++) {
            if (i < mid) {
                System.out.print(" " + (mid - i)); // Reverse first half
            } else if (i == mid) {
                System.out.print(" " + i); // Print middle element
            } else {
                System.out.print(" " + (n - (i - mid))); // Reverse second half
            }
        }
        System.out.println();
    }
}

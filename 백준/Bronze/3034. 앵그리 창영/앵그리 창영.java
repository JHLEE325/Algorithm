import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int maxLenSquare = w * w + h * h;

        for (int i = 0; i < n; i++) {
            int matchLen = sc.nextInt();

            if (matchLen * matchLen <= maxLenSquare) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }

        sc.close();
    }
}
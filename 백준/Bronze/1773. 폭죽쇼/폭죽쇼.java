import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();

        boolean[] timeline = new boolean[c + 1];
        int count = 0;

        for (int i = 0; i < n; i++) {
            int period = sc.nextInt();

            for (int j = period; j <= c; j += period) {
                if (!timeline[j]) {
                    timeline[j] = true;
                    count++;
                }
            }
        }

        System.out.println(count);
        sc.close();
    }
}
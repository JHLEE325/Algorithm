import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int money = sc.nextInt();

            int q = money / 25;
            money %= 25;

            int d = money / 10;
            money %= 10;

            int n = money / 5;
            money %= 5;

            int p = money;

            System.out.println(q + " " + d + " " + n + " " + p);
        }

        sc.close();
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();

        while (t-- > 0) {
            double value = sc.nextDouble();
            String unit = sc.next();

            double result = 0;
            String targetUnit = "";

            if (unit.equals("kg")) {
                result = value * 2.2046;
                targetUnit = "lb";
            } else if (unit.equals("lb")) {
                result = value * 0.4536;
                targetUnit = "kg";
            } else if (unit.equals("l")) {
                result = value * 0.2642;
                targetUnit = "g";
            } else if (unit.equals("g")) {
                result = value * 3.7854;
                targetUnit = "l";
            }

            System.out.printf("%.4f %s\n", result, targetUnit);
        }

        sc.close();
    }
}
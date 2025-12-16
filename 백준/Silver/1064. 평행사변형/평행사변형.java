import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int xA = sc.nextInt();
        int yA = sc.nextInt();
        int xB = sc.nextInt();
        int yB = sc.nextInt();
        int xC = sc.nextInt();
        int yC = sc.nextInt();

        if ((long)(xB - xA) * (yC - yA) == (long)(xC - xA) * (yB - yA)) {
            System.out.println("-1.0");
            return;
        }

        double ab = getDistance(xA, yA, xB, yB);
        double ac = getDistance(xA, yA, xC, yC);
        double bc = getDistance(xB, yB, xC, yC);

        double perim1 = 2 * (ab + ac);
        double perim2 = 2 * (ab + bc);
        double perim3 = 2 * (ac + bc);

        double maxPerim = Math.max(perim1, Math.max(perim2, perim3));
        double minPerim = Math.min(perim1, Math.min(perim2, perim3));

        System.out.println(maxPerim - minPerim);
    }

    private static double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();

        if (a > b) {
            long temp = a;
            a = b;
            b = temp;
        }

        long count = b - a + 1;
        long sum = (a + b) * count / 2;

        System.out.println(sum);
        
        sc.close();
    }
}
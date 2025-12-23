import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String n = sc.next();

            if (n.equals("0")) {
                break;
            }

            int totalWidth = 0;

            totalWidth += 2;

            totalWidth += (n.length() - 1);

            for (int i = 0; i < n.length(); i++) {
                char num = n.charAt(i);
                if (num == '1') {
                    totalWidth += 2;
                } else if (num == '0') {
                    totalWidth += 4;
                } else {
                    totalWidth += 3;
                }
            }

            System.out.println(totalWidth);
        }
        
        sc.close();
    }
}
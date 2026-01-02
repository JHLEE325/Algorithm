import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] castle = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            castle[i] = line.toCharArray();
        }

        int rowNeed = 0;
        for (int i = 0; i < n; i++) {
            boolean hasGuard = false;
            for (int j = 0; j < m; j++) {
                if (castle[i][j] == 'X') {
                    hasGuard = true;
                    break;
                }
            }
            if (!hasGuard) rowNeed++;
        }

        int colNeed = 0;
        for (int j = 0; j < m; j++) {
            boolean hasGuard = false;
            for (int i = 0; i < n; i++) {
                if (castle[i][j] == 'X') {
                    hasGuard = true;
                    break;
                }
            }
            if (!hasGuard) colNeed++;
        }

        System.out.println(Math.max(rowNeed, colNeed));

        sc.close();
    }
}
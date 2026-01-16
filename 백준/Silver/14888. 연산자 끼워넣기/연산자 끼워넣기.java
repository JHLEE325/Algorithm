import java.util.Scanner;

public class Main {
    static int n;
    static int[] numbers;
    static int[] operators = new int[4];
    static int maxVal = Integer.MIN_VALUE;
    static int minVal = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            operators[i] = sc.nextInt();
        }

        dfs(1, numbers[0]);

        System.out.println(maxVal);
        System.out.println(minVal);
        
        sc.close();
    }

    static void dfs(int idx, int currentResult) {
        if (idx == n) {
            maxVal = Math.max(maxVal, currentResult);
            minVal = Math.min(minVal, currentResult);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

                switch (i) {
                    case 0: dfs(idx + 1, currentResult + numbers[idx]); break;
                    case 1: dfs(idx + 1, currentResult - numbers[idx]); break;
                    case 2: dfs(idx + 1, currentResult * numbers[idx]); break;
                    case 3: dfs(idx + 1, currentResult / numbers[idx]); break;
                }

                operators[i]++;
            }
        }
    }
}
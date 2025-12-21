import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s1 = sc.nextInt();
        int s2 = sc.nextInt();
        int s3 = sc.nextInt();

        int[] sumCounts = new int[81];

        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                for (int k = 1; k <= s3; k++) {
                    int sum = i + j + k;
                    sumCounts[sum]++;
                }
            }
        }

        int maxCount = 0;
        int result = 0;

        for (int i = 3; i < sumCounts.length; i++) {
            if (sumCounts[i] > maxCount) {
                maxCount = sumCounts[i];
                result = i;
            }
        }

        System.out.println(result);
        
        sc.close();
    }
}
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
            long n = sc.nextLong();
            int count = 0;


            while (n > 2) {
                if (isPerfectSquare(n)) {
                    n = (long) Math.sqrt(n);
                    count++;
                } else {
                    long sqrt = (long) Math.sqrt(n);
                    long nextPerfectSquare = (sqrt + 1) * (sqrt + 1);

                    count+=nextPerfectSquare-n;
                    n = nextPerfectSquare;
                }
            }

            sb.append("#" + t + " " + count + "\n");
        }

        System.out.println(sb);
    }

    public static boolean isPerfectSquare(long num) {
        long sqrt = (long) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}
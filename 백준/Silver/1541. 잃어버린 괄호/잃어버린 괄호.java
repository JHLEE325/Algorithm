import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        String[] subtractionGroups = input.split("-");

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < subtractionGroups.length; i++) {
            int tempSum = 0;

            String[] additionGroups = subtractionGroups[i].split("\\+");
            for (String num : additionGroups) {
                tempSum += Integer.parseInt(num);
            }

            if (result == Integer.MAX_VALUE) {
                result = tempSum;
            } else {
                result -= tempSum;
            }
        }

        System.out.println(result);
        sc.close();
    }
}
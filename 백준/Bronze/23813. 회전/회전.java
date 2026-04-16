import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        int length = s.length();
        long digitSum = 0;

        for (int i = 0; i < length; i++) {
            digitSum += (s.charAt(i) - '0');
        }

        long multiplier = 0;
        for (int i = 0; i < length; i++) {
            multiplier = multiplier * 10 + 1;
        }

        System.out.println(digitSum * multiplier);
    }
}
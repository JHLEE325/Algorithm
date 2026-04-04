import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int numerator = Integer.parseInt(st.nextToken());
            int denominator = Integer.parseInt(st.nextToken()); 

            if (numerator == 0 && denominator == 0) break;

            int wholeNumber = numerator / denominator;
            int remainder = numerator % denominator;

            sb.append(wholeNumber).append(" ")
              .append(remainder).append(" / ")
              .append(denominator).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}
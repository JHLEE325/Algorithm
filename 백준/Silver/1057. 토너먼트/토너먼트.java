import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int count = 0;
        while (j != h) {
            j = (j + 1) / 2;
            h = (h + 1) / 2;
            count++;
        }

        System.out.println(count);
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int x = 1;
        while (true) {
            int cnt = 0;
            for (int n : nums) {
                if (x % n == 0) cnt++;
            }
            if (cnt >= 3) {
                System.out.println(x);
                break;
            }
            x++;
        }
    }
}

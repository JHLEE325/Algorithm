import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		long[] arr = new long[n + 1];

		arr[1] = 1;

		for (int i = 2; i <= n; i++) {
			if (i % 2 == 0) {
				arr[i] = (arr[i - 1] * 2 + 1)%10007;
			} else {
				arr[i] = (arr[i - 1] * 2 - 1)%10007;
			}
		}

		System.out.println(arr[n]%10007);
	}

}

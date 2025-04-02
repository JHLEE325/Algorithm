import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		long[] arr = new long[1001];

		arr[1] = 1;
		arr[2] = 3;

		for (int i = 3; i <= n; i++) {
			arr[i] = (arr[i - 1] + 2 * arr[i - 2]) % 10007;
		}

		System.out.println(arr[n]);
	}

}

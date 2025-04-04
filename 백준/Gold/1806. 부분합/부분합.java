import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0, right = 0, sum = 0, min = Integer.MAX_VALUE;

		while (true) {
			if (sum >= m) {
				min = Math.min(min, right - left);
				sum -= arr[left++];
			} else if (right == n) {
				break;
			} else {
				sum += arr[right++];
			}
		}

		System.out.println(min == Integer.MAX_VALUE ? 0 : min);
	}
}

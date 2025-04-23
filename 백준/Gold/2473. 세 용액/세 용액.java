import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);

		long min = Long.MAX_VALUE;
		long a = 0, b = 0, c = 0;

		for (int i = 0; i < n - 2; i++) {
			int left = i + 1;
			int right = n - 1;

			while (left < right) {
				long sum = arr[i] + arr[left] + arr[right];

				if (Math.abs(sum) < min) {
					min = Math.abs(sum);
					a = arr[i];
					b = arr[left];
					c = arr[right];
				}

				if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}

		System.out.println(a + " " + b + " " + c);
	}
}

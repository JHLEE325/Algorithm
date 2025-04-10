import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0, right = n - 1;
		int lidx = 0, ridx = 0;
		long tmp = Integer.MAX_VALUE;

		while (left < right) {
			long num = arr[left] + arr[right];
			if (tmp > Math.abs(num)) {
				tmp = Math.abs(num);
				lidx = left;
				ridx = right;
			}
			if (num > 0)
				right--;
			else
				left++;
		}

		System.out.println(arr[lidx] + " " + arr[ridx]);
	}

}

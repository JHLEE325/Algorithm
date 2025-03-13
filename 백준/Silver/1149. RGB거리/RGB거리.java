import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[3];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int r2 = Math.min(arr[1] + r, arr[2] + r);
			int g2 = Math.min(arr[0] + g, arr[2] + g);
			int b2 = Math.min(arr[0] + b, arr[1] + b);

			arr[0] = r2;
			arr[1] = g2;
			arr[2] = b2;
		}

		int res = Math.min(Math.min(arr[0], arr[1]), arr[2]);
		System.out.println(res);

	}
}
import java.io.*;
import java.util.*;

public class Main {

	static int MOD;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		MOD = Integer.parseInt(st.nextToken());

		System.out.println(pow(a, b));

	}

	static long pow(long a, int b) {
		if (b == 0)
			return 1;
		long half = pow(a, b / 2);
		long result = (half * half) % MOD;
		if (b % 2 == 1)
			result = (result * a) % MOD;
		return result;
	}
}
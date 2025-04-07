import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		long[] pado = new long[101];
		pado[1] = pado[2] = pado[3] = 1;
		for (int i = 4; i <= 100; i++) {
			pado[i] = pado[i - 2] + pado[i - 3];
		}

		for (int t = 0; t < T; t++) {
			System.out.println(pado[Integer.parseInt(br.readLine())]);
		}
	}
}

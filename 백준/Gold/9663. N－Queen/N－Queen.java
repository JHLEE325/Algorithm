import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int count, N, ans;
	static boolean[] col, slash, bslash;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		col = new boolean[N+1];
		slash = new boolean[2*N+1];
		bslash = new boolean[2*N];
		
		setQueens(1);
		System.out.println(ans);
	}

	private static void setQueens(int rowNo) {

		if (rowNo > N) {
			ans++;
			return;
		}

		for (int c = 1; c <= N; c++) {
			if (!isAvailable(rowNo, c))
				continue;
			col[c] = slash[rowNo + c] = bslash[(rowNo - c) + N] = true;
			setQueens(rowNo + 1);
			col[c] = slash[rowNo + c] = bslash[(rowNo - c) + N] = false;
		}

	}

	private static boolean isAvailable(int rowNo, int c) {
		return !col[c] && !slash[rowNo + c] && !bslash[(rowNo - c) + N];
	}

}

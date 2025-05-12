import java.io.*;
import java.util.*;

public class Main {

	static long x, y, w, s, res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		long height = Math.min(x, y);

		if (s <= 2 * w) {
			res += s * height;
		} else {
			res += w * 2 * height;
		}

		long width = Math.max(x, y) - Math.min(x, y);
		if (width % 2 == 0) {
			if (2 * s <= 2 * w) {
				res += 2 * s * (width / 2);
			} else {
				res += w * width;
			}
		} else {
			if (2 * s <= 2 * w) {
				res += 2 * s * (width / 2);
				res += w;
			} else {
				res += w * width;
			}
		}

		System.out.println(res);
	}

}

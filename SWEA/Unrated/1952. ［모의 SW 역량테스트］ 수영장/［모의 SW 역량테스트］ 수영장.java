import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] swim, pricelist;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			pricelist = new int[4];
			swim = new int[15];
			result = Integer.MAX_VALUE;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				pricelist[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				swim[i] = Integer.parseInt(st.nextToken());
			}
			calprice(1, 0);
			sb.append("#" + t + " " + result + "\n");
		}
		System.out.println(sb);
	}

	public static void calprice(int month, int price) {
		if (month > 12) {
			if (result > price) {
				result = price;
			}
			return;
		}
		if (swim[month] == 0) {
			calprice(month + 1, price);
		} else {
			calprice(month + 1, price + (swim[month] * pricelist[0]));
			calprice(month + 1, price + (pricelist[1]));
			calprice(month + 3, price + (pricelist[2]));
			calprice(month + 12, price + (pricelist[3]));
		}

	}

}

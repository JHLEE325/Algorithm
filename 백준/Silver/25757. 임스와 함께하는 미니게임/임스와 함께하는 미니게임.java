import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		String game = st.nextToken();
		HashMap<String, Integer> hash = new HashMap<>();

		for (int i = 0; i < num; i++) {
			hash.put(br.readLine(), null);
		}

		int length = hash.size();

		switch (game) {
		case "Y":
			System.out.println(length / 1);
			break;
		case "F":
			System.out.println(length / 2);
			break;
		case "O":
			System.out.println(length / 3);
			break;
		}
	}

}
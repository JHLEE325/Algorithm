import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		int[] lis = new int[n];
		int[] position = new int[n];
		int[] parent = new int[n];
		int size = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			int pos = binarySearch(lis, 0, size, arr[i]);

			lis[pos] = arr[i];
			position[pos] = i;
			if (pos > 0)
				parent[i] = position[pos - 1];
			else
				parent[i] = -1;

			if (pos == size)
				size++;
		}

		List<Integer> list = new ArrayList<>();
		int idx = position[size - 1];
		while (idx != -1) {
			list.add(arr[idx]);
			idx = parent[idx];
		}
		Collections.reverse(list);

		System.out.println(size);
		for (int a : list) {
			System.out.print(a + " ");
		}
	}

	static int binarySearch(int[] arr, int lo, int hi, int target) {
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (arr[mid] >= target) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		return lo;
	}

}

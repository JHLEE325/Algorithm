import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		int[] lis = new int[n];
		int size = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 0; i < n; i++) {
            int pos = binarySearch(lis, 0, size, arr[i]);

            lis[pos] = arr[i];

            if(pos == size) size++;
        }

        System.out.println(size);
    }

    static int binarySearch(int[] arr, int lo, int hi, int target) {
        while(lo < hi) {
            int mid = (lo + hi) / 2;
            if(arr[mid] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class node {
		char name;
		node lchild;
		node rchild;

		public node() {
			lchild = rchild = null;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		node[] list = new node[n];
		for (int i = 0; i < n; i++) {
			list[i] = new node();
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			char c1 = st.nextToken().charAt(0);
			char c2 = st.nextToken().charAt(0);
			char c3 = st.nextToken().charAt(0);
			list[c1-'A'].name = c1;
			if (c2 != '.') {
				list[c1-'A'].lchild = list[c2 - 'A'];
			}
			if (c3 != '.') {
				list[c1-'A'].rchild = list[c3 - 'A'];
			}
		}

		preorder(list[0]);
		System.out.println();
		inorder(list[0]);
		System.out.println();
		postorder(list[0]);
	}

	public static void preorder(node n) {
		if (n == null) {
			return;
		}
		System.out.print(n.name);
		preorder(n.lchild);
		preorder(n.rchild);
	}

	public static void inorder(node n) {
		if (n == null) {
			return;
		}

		inorder(n.lchild);
		System.out.print(n.name);
		inorder(n.rchild);
	}

	public static void postorder(node n) {
		if (n == null) {
			return;
		}

		postorder(n.lchild);
		postorder(n.rchild);
		System.out.print(n.name);
	}
}

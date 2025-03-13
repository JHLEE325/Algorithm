import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static class Node {
		int num;
		Node lchild;
		Node rchild;

		public Node(int num) {
			this.num = num;
			lchild = rchild = null;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Node root = new Node(Integer.parseInt(br.readLine()));

		Stack<Node> stack = new Stack<>();

		while (true) {
			String s = br.readLine();
			if (s == null || s.equals(""))
				break;

			if (stack.isEmpty()) {
				stack.push(root);
			}

			Node tmp = new Node(Integer.parseInt(s));

			if (stack.peek().num > tmp.num) {
				stack.peek().lchild = tmp;
				stack.push(tmp);
			} else {
				Node parent = null;
				while (!stack.isEmpty() && stack.peek().num < tmp.num) {
					parent = stack.pop();
				}
				parent.rchild = tmp;
				stack.push(tmp);
			}
		}

		print(root);
	}

	public static void print(Node n) {
		if (n == null) {
			return;
		}
		print(n.lchild);
		print(n.rchild);
		System.out.println(n.num);
	}

}

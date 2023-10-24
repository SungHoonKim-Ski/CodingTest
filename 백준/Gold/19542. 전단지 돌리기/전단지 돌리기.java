import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int s;
	static int d;
	static ArrayList<Integer>[] g;
	static int ans = 0;

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] str = br.readLine().split(" ");
			n = Integer.parseInt(str[0]);
			s = Integer.parseInt(str[1]) - 1;
			d = Integer.parseInt(str[2]);
			g = new ArrayList[n];

			for (int i = 0; i < n; i++)
				g[i] = new ArrayList<Integer>();

			for (int i = 0; i < n - 1; i++) {
				str = br.readLine().split(" ");
				int a = Integer.parseInt(str[0]) - 1;
				int b = Integer.parseInt(str[1]) - 1;
				g[a].add(b);
				g[b].add(a);
			}

			dfs(s, -1);
			System.out.println(ans * 2);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static int dfs(int now, int prev) {
		int max = 0;
		for (int next : g[now]) {
			if (next != prev) {
				max = Math.max(max, dfs(next, now) + 1);
			}
		}
		if (now != s && max >= d) {
			ans++;
		}
		return max;
	}

}
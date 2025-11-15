import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int maxX, maxY, minX, minY;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        minX = 1501;
        minY = 1501;

        for (int i = 0; i < n; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (arr[j] == 'G') {
                    maxX = Math.max(maxX, i + 1);
                    maxY = Math.max(maxY, j + 1);
                    minX = Math.min(minX, i + 1);
                    minY = Math.min(minY, j + 1);
                }
            }
        }
        int ans = 0;
        if (minX != maxX) {
            ans += Math.min(maxX - 1, n - minX);
        }

        if (minY != maxY) {
            ans += Math.min(maxY - 1, n - minY);
        }
        System.out.println(ans);
    }
}
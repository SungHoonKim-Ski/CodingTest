import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n;
    static long k;
    static ArrayList<Long> list;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int count = 0;

        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long x = Long.parseLong(st.nextToken());

            if (x >= k) count++;
            else list.add(x);
        }

        Collections.sort(list);
        int left = 0, right = list.size() - 1;
        int use = 0;
        while (left < right) {
            if ((list.get(left) + list.get(right)) * 2 >= k) {
                use += 2;
                count++;
                left++; right--;
            } else {
                left++;
            }
        }

        count += (list.size() - use) / 3;

        System.out.println(count);
    }
}
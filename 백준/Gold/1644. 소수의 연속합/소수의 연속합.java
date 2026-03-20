import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static boolean[] isNotPrime;
    static int n;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
    }

    static void pro() throws IOException{
        findPrime();
        System.out.println(check());
    }

    static int check() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++){
            if (!isNotPrime[i]) list.add(i);
        }
        if (list.size() == 0) return 0;

        int left = 0, right = 0, size = list.size();
        long sum = 0;

        while (sum < n) {
            sum += list.get(right);
            right++;
        }
        right--;

        int cnt = 0;
        while (right < size) {
            if (sum > n) {
                sum -= list.get(left);
                left++;
            } else {
                if (sum == n) {
                    cnt++;
                }

                right++;
                if (right != size) sum += list.get(right);
            }
        }

        return cnt;
    }

    static void findPrime() {
        isNotPrime = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            if (isNotPrime[i]) continue;

            for (int j = i + i; j <= n; j += i) {
                isNotPrime[j] = true;
            }
        }
    }



    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
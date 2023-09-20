import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    //        Scanner sc = new Scanner(new InputStreamReader(System.in));
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();

    static int T, N, M;
    static int[] arrA, arrB;
    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < T; i++) {
            input();
            Arrays.sort(arrB);
            pro();
        }

        System.out.println(sb);
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arrA = new int[N];
        arrB = new int[M + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {

        int res = 0;
        for (int i = 0; i < N; i++) {
            res += binarySearch(arrA[i]);
        }
        sb.append(res).append('\n');
    }

    static int binarySearch(int element) {

        int L = 1, R = M, mid = 0, res = 0;
        while (L <= R) {
            mid = (L + R) / 2;
            if(arrB[mid] < element) {
                res = mid;
                L = mid + 1;
            }else { // mid >= element
                R = mid - 1;
            }
        }
        return res;
    }
}

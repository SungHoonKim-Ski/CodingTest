import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    static int N, M;
    static int[] Prev_Val;
    static StringBuffer sb;
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new InputStreamReader(System.in));
        N = sc.nextInt();
        M = sc.nextInt();
        sb = new StringBuffer();
        Prev_Val = new int[M + 1];
        recur_func(1);

        System.out.println(sb);
    }

    static void recur_func(int depth) {
        if (depth == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(Prev_Val[i]).append(' ');
            }
            sb.append('\n');
        }else {
            for (int i = 1; i <= N; i++) {
                Prev_Val[depth] = i;
                recur_func(depth + 1);
            }
        }
    }
}

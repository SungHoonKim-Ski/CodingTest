import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    static int N;
    static StringBuffer sb;
    static int cnt = 0;
    static int[] queenLoc;

    public static void main(String[] args) {

        Scanner sc = new Scanner(new InputStreamReader(System.in));
        N = sc.nextInt();
        queenLoc = new int[N + 1];
        recur_func(1);
        System.out.println(cnt);
    }

    static void recur_func(int depth) {
        if (depth == N + 1) {
            cnt++;
        } else {
            for (int i = 1; i <= N; i++) {
                boolean possible = true;
                for (int j = 1; j < depth; j++){
                    if (attackable(depth, i, j, queenLoc[j])){
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    queenLoc[depth] = i;
                    recur_func(depth + 1);
                    queenLoc[depth] = 0;
                }
            }
        }
    }
    static boolean attackable(int x1, int y1, int x2, int y2) {
        if (y1 == y2) return true;
        if (x1 + y1 == x2 + y2) return true;
        if (x1 - y1 == x2 - y2) return true;
        return false;
    }

}

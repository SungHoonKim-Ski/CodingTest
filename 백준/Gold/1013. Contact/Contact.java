import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static char[] str;
    static int length;
    static void input() throws IOException{
        str = br.readLine().toCharArray();
        length = str.length;
    }

    static void pro() {

        Deque<int[]> que = new ArrayDeque<>();
        que.add(new int[] {0, 2});

        boolean isPattern = false;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int curIdx = cur[0];
            int curCase = cur[1];

            if (curIdx > length) continue;

            if (curIdx == length) {
                if (curCase != 0) {
                    isPattern = true;
                    break;
                }
                continue;
            }

            if (curCase == 0) { // 100 + 인경우
                if(str[curIdx] == '0') {
                    que.add(new int[] {curIdx + 1, 0});
                    continue;
                }
                if (str[curIdx] == '1') {
                    que.add(new int[] {curIdx + 1, 1});
                    continue;
                }
                continue;
            }

            if (curCase == 1) { // 1+ 인 경우
                if (str[curIdx] == '1') {
                    que.add(new int[] {curIdx + 1, 1});
                }
            }

            if (curIdx + 1 < length && str[curIdx] == '0' && str[curIdx + 1] == '1') {
                que.add(new int[] {curIdx + 2, 2});
            }

            if (curIdx + 2 < length && str[curIdx] == '1' && str[curIdx + 1] == '0' && str[curIdx + 2] == '0') {
                que.add(new int[] {curIdx + 3, 0});
            }
        }

        sb.append(isPattern ? "YES" : "NO").append('\n');
    }

    public static void main(String[] args) throws IOException{
        int tc = Integer.parseInt(br.readLine());
        while (tc -- > 0) {
            input();
            pro();
        }
        System.out.println(sb);
    }
}
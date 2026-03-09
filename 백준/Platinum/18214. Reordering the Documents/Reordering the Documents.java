    import java.io.*;
    import java.util.*;

    public class Main {
        static StringTokenizer st;
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringBuilder sb = new StringBuilder();

        static int n, m;
        static final long MOD = 1_000_000_007;

        static int[] arr;
        static int[] color;
        static int[][] comp;
        static int compCnt;

        static long[][] dp;

        static void input() throws IOException {
            st = new StringTokenizer(br.readLine());
    
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            arr = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
        }

        static void pro() {
            color = new int[n + 1];
            comp = new int[n + 1][2];
            compCnt = 0;

            if (!make()) {
                System.out.println(0);
                return;
            }

            dp = new long[compCnt + 1][n + 1];
            for (int i = 0; i <= compCnt; i++) {
                Arrays.fill(dp[i], -1);
            }

            System.out.println(recur(0, 0));
        }

        static long recur(int idx, int leftCnt) {
            if (leftCnt > m) return 0;

            if (idx == compCnt) {
                int rightCnt = n - leftCnt;
                
                if (rightCnt > m) return 0;
                else return 1;
            }

            if (dp[idx][leftCnt] != -1) return dp[idx][leftCnt];

            int a = comp[idx][0];
            int b = comp[idx][1];

            long sum = 0;
            sum += recur(idx + 1, leftCnt + a);
            sum += recur(idx + 1, leftCnt + b);

            return dp[idx][leftCnt] = sum % MOD;
        }

        static boolean make() {
            ArrayDeque<Integer> que = new ArrayDeque<>();

            for (int i = 1; i <= n; i++) {
                if (color[i] != 0) continue;

                comp[compCnt][0] = 0;
                comp[compCnt][1] = 0;

                color[i] = 1;
                comp[compCnt][0]++;
                que.add(i);

                while (!que.isEmpty()) {
                    int cur = que.poll();

                    for (int next = 1; next <= n; next++) {
                        if (cur == next) continue;
                        if (!check(cur, next)) continue;

                        if (color[next] == 0) {
                            color[next] = -color[cur];
                            if (color[next] == 1) comp[compCnt][0]++;
                            else comp[compCnt][1]++;
                            que.add(next);
                        } else if (color[next] == color[cur]) {
                            return false;
                        }
                    }
                }

                compCnt++;
            }

            return true;
        }

        static boolean check(int i, int j) {
            if (i < j) return arr[i] > arr[j];
            return arr[j] > arr[i];
        }

        public static void main(String[] args) throws IOException {
            input();
            pro();
        }
    }
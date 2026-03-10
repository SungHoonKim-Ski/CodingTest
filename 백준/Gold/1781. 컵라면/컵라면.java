    import java.io.*;
    import java.util.*;

    public class Main {
        static StringTokenizer st;
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringBuilder sb = new StringBuilder();

        static int n;
        static long[][] arr;
        static PriorityQueue<Long> pq;

        static void input() throws IOException {
            n = Integer.parseInt(br.readLine());
            pq = new PriorityQueue<>();

            arr = new long[n][];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i] = new long[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
            }
        }

        static void pro() {
            Arrays.sort(arr, (o1, o2) -> {
               if (o1[0] != o2[0]) return Long.compare(o1[0], o2[0]);
               else return Long.compare(o2[1], o1[1]);
            });

            long sum = 0;
            for (int i = 0; i < n; i++) {
                long x = arr[i][0];
                long y = arr[i][1];

                pq.add(y);
                sum += y;

                if (pq.size() > x) {
                    sum -= pq.poll();
                }
            }

            System.out.println(sum);
        }

        public static void main(String[] args) throws IOException {
            input();
            pro();
        }
    }
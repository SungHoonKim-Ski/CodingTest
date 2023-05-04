import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;

    static void input() {
        N = scan.nextInt();
    }


    static void pro() {

        PriorityQueue<Integer> nagHeap = new PriorityQueue<>();
        PriorityQueue<Integer> posHeap = new PriorityQueue<>();

        while (N-- > 0) {
            int input = scan.nextInt();
            if (input == 0) {
                if (nagHeap.size() == 0 && posHeap.size() == 0) sb.append(0).append('\n');
                else {

                    if (nagHeap.size() == 0) {
                        sb.append(posHeap.poll()).append('\n');
                        continue;
                    }
                    if (posHeap.size() == 0) {
                        sb.append(-nagHeap.poll()).append('\n');
                        continue;
                    }
                    if (nagHeap.peek() > posHeap.peek()) {
                        sb.append(posHeap.poll()).append('\n');
                    } else {
                        sb.append(-nagHeap.poll()).append('\n');
                    }
                }
            } else{
                if (input > 0) posHeap.add(input);
                else nagHeap.add(-input);
            }

        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        pro();
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
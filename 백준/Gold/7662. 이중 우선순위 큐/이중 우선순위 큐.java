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

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        StringTokenizer st;
        while (N-- > 0) {
            st = new StringTokenizer(scan.nextLine());
            if (st.nextToken().charAt(0) == 'I') {
                int input = Integer.parseInt(st.nextToken());
                if (hashMap.containsKey(input)) {
                    hashMap.replace(input, hashMap.get(input) + 1);
                } else{
                    maxHeap.add(input);
                    minHeap.add(input);
                    hashMap.put(input, 1);
                }
            }else {
                if(minHeap.size() == 0) continue;
                int input = Integer.parseInt(st.nextToken());
                if (input == -1) {
                    int minVal = minHeap.peek();
                    int hashVal = hashMap.get(minVal);
                    if (hashVal == 1) {
                        minHeap.poll();
                        maxHeap.remove(minVal);
                        hashMap.remove(minVal);
                    } else{
                        hashMap.replace(minVal, hashVal - 1);
                    }
                }else {
                    int maxVal = maxHeap.peek();
                    int hashVal = hashMap.get(maxVal);
                    if (hashVal == 1) {
                        maxHeap.poll();
                        minHeap.remove(maxVal);
                        hashMap.remove(maxVal);
                    } else{
                        hashMap.replace(maxVal, hashVal - 1);
                    }
                }
            }
        }

        if (maxHeap.size() == 0) {
            sb.append("EMPTY");
        }else {
            sb.append(maxHeap.poll()).append(' ').append(minHeap.poll());
        }
        sb.append('\n');
    }

    public static void main(String[] args) {
        int tc = scan.nextInt();
        while (tc-- > 0) {
            input();
            pro();
        }
        System.out.println(sb);
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
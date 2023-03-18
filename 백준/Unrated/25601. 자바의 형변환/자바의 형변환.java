import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static HashMap<String, HashSet<String>> classMap = new HashMap<>();

    static void pro() {

        int N = scan.nextInt();
        for (int i = 1; i < N; i++) {
            String child = scan.next();
            String parent = scan.next();
            if (!classMap.containsKey(child)) {
                classMap.put(child, new HashSet<>());
            }
            classMap.get(child).add(parent);
        }
        String child = scan.next();
        String parent = scan.next();
        if (find(child, parent) || find(parent, child)) System.out.println(1);
        else System.out.println(0);
    }

    static boolean find(String child, String find) {
        if (child.equals(find)) return true;
        if (!classMap.containsKey(child)) return false;
        else {
            Iterator it = classMap.get(child).iterator();
            while (it.hasNext()) {
                String parent = it.next().toString();
                return find(parent, find);
            }
        }
        return false;
    }

    public static void main(String[] args) {
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

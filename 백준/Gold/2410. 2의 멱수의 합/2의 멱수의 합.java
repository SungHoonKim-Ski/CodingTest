import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[] d;
    static int N;

    static void input() {
        N = scan.nextInt();
        d = new int[1000001];
    }

    static void pro() {
    	
    	d[1] = 1;
    	d[2] = 2;
    	
    	for (int i = 3; i <= N; i++) {
    		if(i % 2 == 0) {
    			d[i] = (d[i - 1] + d[i / 2]) % 1000000000;
    		}
    		else {
    			d[i] = d[i - 1];  
    		}
    	}
    	
    	
    	System.out.println(d[N]);
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
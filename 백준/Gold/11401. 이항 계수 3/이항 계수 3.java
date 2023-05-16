import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;


    static long N, R;
    static long mod = 1000000007;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        R = Long.parseLong(st.nextToken());
    }

    public static long factorial(long N) {

        long fac = 1;
        while(N > 1) {
            fac = (fac * N) % mod;
            N--;
        }
        return fac;
    }

    static void pro() throws Exception{
        long numer = factorial(N);
        long denom = factorial(R) * factorial(N - R) % mod;
        long res = numer * pow(denom, mod - 2) % mod;
        System.out.println(res);
    }

    public static long pow(long base, long expo) {
        long result = 1;

        while (expo > 0) {

            if (expo % 2 == 1) {
                result *= base;
                result %= mod;
            }
            base = (base * base) % mod;
            expo /= 2;
        }
        return result;
    }

    public static void main(String[] args) throws Exception{

        br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("res/input.txt")));
        input();
        pro();
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] isPrime = new boolean[1000001];
        isPrime[0] = true;
        isPrime[1] = true;

        for (int i = 2; i <= Math.sqrt(1000000); i++) {
            for (int j = 2; i * j < 1000001; j++) {
                isPrime[i * j] = true;
            }
        }

        while (true) {
            
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            
            boolean checked = false;
            for (int i = 2; i <= n / 2; i++) {
                if (!isPrime[i] && !isPrime[n - i]) {
                    System.out.println(n + " = " + i + " + " + (n - i));
                    checked = true;
                    break;
                }
            }
            if (!checked) System.out.println("Goldbach's conjecture is wrong.");
        }
    }
}

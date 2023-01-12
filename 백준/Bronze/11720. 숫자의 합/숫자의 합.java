import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws IOException {

        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] c = br.readLine().toCharArray();
        int sum = 0;
        for (int i=0; i<n; i++) {
            sum += (c[i] - '0');
        }
        
        System.out.println(sum);
    }
}

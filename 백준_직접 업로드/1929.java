import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        int[] a = new int[n+1];

        for(int i=2;i<=n;i++) {
            a[i] = i;
        }

        for(int i=2;i<=n;i++) {
            if(a[i]==0) {
                continue;
            }
            for(int j=i+i;j<=n; j+=i) {
                a[j] = 0;
            }
        }

        for(int i=m;i<=n;i++) {
            if(a[i]!=0){
                System.out.println(a[i]);
            }
        }

    }
}


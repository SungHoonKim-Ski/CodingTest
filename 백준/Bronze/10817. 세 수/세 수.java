import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int[] input = new int[3];
        for (int i = 0; i < input.length; i++) input[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(input);
        System.out.println(input[1]);
    }
}

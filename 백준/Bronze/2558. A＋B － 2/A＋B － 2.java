import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char a = br.readLine().charAt(0);
        char b = br.readLine().charAt(0);

        System.out.println(a + b - '0' - '0');
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            sb.append(sc.nextLine()).append('\n');
        }

        System.out.println(sb);
    }
}

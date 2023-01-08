import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        char[] resChar = br.readLine().toCharArray();
        for (int i=1; i<T; i++) {
            char[] compareChar = br.readLine().toCharArray();
            for (int j=0; j<resChar.length; j++){
                if (resChar[j] != compareChar[j]) {
                    if (resChar[j] != '?') resChar[j] = '?';
                }
            }
        }
        for (int i=0; i<resChar.length; i++){
            sb.append(resChar[i]);
        }

        System.out.println(sb);
    }
}
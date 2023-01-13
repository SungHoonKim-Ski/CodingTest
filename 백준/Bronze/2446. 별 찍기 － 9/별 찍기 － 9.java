import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {

        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = (Integer.parseInt(br.readLine()) * 2 - 1);
        for (int i=0; i<=x; i++) {
            if (i < x/2) {
                for (int j=0; j<i; j++) sb.append(' ');
                for (int j=0; j<x-(i*2); j++) sb.append('*');
            }else if (i > x/2){
                for (int j=0; j<x-i; j++) sb.append(' ');
                for (int j=0; j<(i*2)-x; j++) sb.append('*');
            } else continue;
            sb.append('\n');
        }
        System.out.println(sb);
    }
}

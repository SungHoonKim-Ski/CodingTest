import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input;
        StringTokenizer st ;

        input = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int min = Integer.parseInt(st.nextToken());
        int max = min;
        for(int i=1; i<input; i++){
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp > max){
                max = tmp;
            }
            if(tmp < min){
                min = tmp;
            }
        }

        StringBuffer sb = new StringBuffer();
        sb.append(min);
        sb.append(" ");
        sb.append(max);

        System.out.println(sb);
        return;
    }
}

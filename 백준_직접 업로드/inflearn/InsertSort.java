import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] inputArr = new int[count];
        for(int i=0; i<count; i++){
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<count; i++){

            int tmp = inputArr[i];
            int aux = i - 1;

            while (aux >=0 && (inputArr[aux] > tmp)){
                inputArr[aux + 1] = inputArr[aux];
                aux--;
            }
            inputArr[aux + 1] = tmp;
        }

        for(int i=0; i<count; i++){
            sb.append(inputArr[i]).append(' ');
        }

        System.out.println(sb);
    }
}
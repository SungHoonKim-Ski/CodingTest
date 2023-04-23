import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputSize = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<inputSize; i++){
            String[] input = br.readLine().split(" ");

            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            int dis = end - start;
            int max = (int)Math.sqrt(dis);

            if(max == Math.sqrt(dis)) {
                sb.append(max * 2 - 1).append('\n');
            }
			else if(dis <= max * max + max) {
                sb.append(max * 2).append('\n');
            }
            else {
                sb.append(max * 2 + 1).append('\n');
            }
        }

        System.out.println(sb.toString());
    }
}


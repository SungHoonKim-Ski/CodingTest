import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Main {

    public static void main(String args[])throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int count = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue();

        while (count-- > 0){
            int input = Integer.parseInt(br.readLine());
            if(input == 0){
                if(pq.size() > 0){
                    sb.append(pq.poll()).append('\n');
                }else{
                    sb.append(0).append('\n');
                }
            }else{
                pq.add(input);
            }
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}

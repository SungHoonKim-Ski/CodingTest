import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    //    private static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        String[] inputSplit = br.readLine().split(" ");
        int n = Integer.parseInt(inputSplit[0]);
        int k = Integer.parseInt(inputSplit[1]);

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++){
            queue.add(i);
        }

        int count = 1;
        sb.append("<");
        while (queue.size() != 0){
            if(count % k == 0){
                sb.append(queue.poll() + ", ");
            }else{
                queue.add(queue.poll());
            }
            count++;
        }
        sb.setLength(sb.length()-2);
        sb.append(">");
        System.out.println(sb);

    }

}
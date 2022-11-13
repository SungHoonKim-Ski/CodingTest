import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        String input;
        input = br.readLine();
        int size = Integer.parseInt(input);
        Queue<Integer> queue = new LinkedList<>();
        while(!(input= br.readLine()).equals("-1")){
            int inputNum = Integer.parseInt(input);
            if(inputNum == 0){
                queue.poll();
            }else if(queue.size() == size){
            }else{
                queue.add(inputNum);
            }
        }

        if(queue.isEmpty()){
            System.out.println("empty");
        }else{
            while (!queue.isEmpty()){
                sb.append(queue.poll()).append(' ');
            }
        }
        System.out.println(sb);
    }
}
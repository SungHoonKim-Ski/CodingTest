import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    //    private static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int count = Integer.parseInt(br.readLine());
        Deque queue = new LinkedList();
        while (count > 0){
            String[] inputSplit = br.readLine().split(" ");
            if(inputSplit[0].equals("push_front")){
                queue.addFirst(Integer.parseInt(inputSplit[1]));
            }else if(inputSplit[0].equals("push_back")){
                queue.addLast(Integer.parseInt(inputSplit[1]));
            }else if(inputSplit[0].equals("pop_front")){
                if(queue.size() > 0){
                    sb.append(queue.pollFirst());
                }else{
                    sb.append("-1");
                }
                sb.append("\n");
            }else if(inputSplit[0].equals("pop_back")){
                if(queue.size() > 0){
                    sb.append(queue.pollLast());
                }else{
                    sb.append("-1");
                }
                sb.append("\n");
            }else if(inputSplit[0].equals("size")){
                sb.append(queue.size());
                sb.append("\n");
            }else if(inputSplit[0].equals("empty")){
                if(queue.size() > 0){
                    sb.append("0");
                }else{
                    sb.append("1");
                }
                sb.append("\n");
            }else if(inputSplit[0].equals("front")){
                if(queue.size() > 0){
                    sb.append(queue.peekFirst());
                }else{
                    sb.append("-1");
                }
                sb.append("\n");
            }else if(inputSplit[0].equals("back")){
                if(queue.size() > 0){
                    sb.append(queue.peekLast());
                }else{
                    sb.append("-1");
                }
                sb.append("\n");
            }
            count--;
        }
        System.out.println(sb.toString().trim());;
    }

}